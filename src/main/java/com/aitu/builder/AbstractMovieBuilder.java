package com.aitu.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный базовый класс для строителей фильмов.
 * Содержит общие поля и реализацию сеттеров.
 */
public abstract class AbstractMovieBuilder implements MovieBuilder {
    protected String title;
    protected String directorName;
    protected List<String> cast = new ArrayList<>();
    protected String cinematographyStyle;
    protected String script;
    protected long budgetUsd;
    protected String distributionStrategy;

    @Override
    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public MovieBuilder setDirector(String directorName) {
        this.directorName = directorName;
        return this;
    }

    @Override
    public MovieBuilder addCastMember(String castMember) {
        if (castMember != null && !castMember.isBlank()) {
            this.cast.add(castMember);
        }
        return this;
    }

    @Override
    public MovieBuilder setCinematography(String cinematographyStyle) {
        this.cinematographyStyle = cinematographyStyle;
        return this;
    }

    @Override
    public MovieBuilder setScript(String script) {
        this.script = script;
        return this;
    }

    @Override
    public MovieBuilder setBudget(long budgetUsd) {
        this.budgetUsd = budgetUsd;
        return this;
    }

    /**
     * Проверяет наличие обязательных полей для любого фильма.
     */
    protected void validateFieldsPresentForEveryMovie() {
        if (title == null || title.isBlank()) {
            throw new InvalidMovieConfigurationException("Movie title is required.");
        }
        if (directorName == null || directorName.isBlank()) {
            throw new InvalidMovieConfigurationException("Director name is required.");
        }
        if (budgetUsd <= 0) {
            throw new InvalidMovieConfigurationException("Budget must be greater than zero.");
        }
    }
}
