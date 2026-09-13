package com.aitu.builder;

import java.util.ArrayList;

/**
 * Строитель для блокбастеров.
 */
public class BlockbusterMovieBuilder extends AbstractMovieBuilder {
    private static final long MIN_BLOCKBUSTER_BUDGET_USD = 50_000_000L;
    private static final int MIN_BLOCKBUSTER_CAST_SIZE = 3;
    private static final String DEFAULT_CINEMATOGRAPHY = "IMAX";
    private static final String DISTRIBUTION_STRATEGY = "Wide release";

    @Override
    public Movie build() {
        validateFieldsPresentForEveryMovie();
        validateBlockbusterScale();
        
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

    private void validateBlockbusterScale() {
        if (budgetUsd < MIN_BLOCKBUSTER_BUDGET_USD) {
            throw new InvalidMovieConfigurationException(
                "Blockbuster budget must be at least $" + MIN_BLOCKBUSTER_BUDGET_USD + ". Current: $" + budgetUsd
            );
        }
        if (cast.size() < MIN_BLOCKBUSTER_CAST_SIZE) {
            throw new InvalidMovieConfigurationException(
                "Blockbuster needs a large cast (at least " + MIN_BLOCKBUSTER_CAST_SIZE + " members)."
            );
        }
    }
}
