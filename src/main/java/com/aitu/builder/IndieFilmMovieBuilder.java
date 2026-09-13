package com.aitu.builder;

import java.util.ArrayList;

/**
 * Строитель для инди-фильмов.
 */
public class IndieFilmMovieBuilder extends AbstractMovieBuilder {
    private static final long MAX_INDIE_BUDGET_USD = 5_000_000L;
    private static final String DEFAULT_CINEMATOGRAPHY = "Handheld camera / Natural light";
    private static final String DISTRIBUTION_STRATEGY = "Film Festivals & Indie Streamers";

    @Override
    public Movie build() {
        validateFieldsPresentForEveryMovie();
        validateIndieScale();
        
        if (this.cinematographyStyle == null || this.cinematographyStyle.isBlank()) {
            this.cinematographyStyle = DEFAULT_CINEMATOGRAPHY;
        }
        
        this.distributionStrategy = DISTRIBUTION_STRATEGY;

        return new Movie(
            title, 
            directorName, 
            new ArrayList<>(cast), 
            cinematographyStyle, 
            script, 
            budgetUsd, 
            distributionStrategy
        );
    }

    private void validateIndieScale() {
        if (budgetUsd > MAX_INDIE_BUDGET_USD) {
            throw new InvalidMovieConfigurationException(
                "Indie film budget cannot exceed $" + MAX_INDIE_BUDGET_USD + ". Current: $" + budgetUsd
            );
        }
        if (script == null || script.isBlank()) {
             throw new InvalidMovieConfigurationException(
                "Indie film must have a strong script."
            );
        }
    }
}
