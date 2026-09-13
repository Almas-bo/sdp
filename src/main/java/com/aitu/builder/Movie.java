package com.aitu.builder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс продукта - Фильм.
 */
public class Movie {
    private final String title;
    private final String directorName;
    private final List<String> cast;
    private final String cinematographyStyle;
    private final String script;
    private final long budgetUsd;
    private final String distributionStrategy;

    /**
     * Приватный конструктор, принимающий все поля.
     */
    Movie(String title, String directorName, List<String> cast, String cinematographyStyle,
          String script, long budgetUsd, String distributionStrategy) {
        this.title = title;
        this.directorName = directorName;
        this.cast = cast;
        this.cinematographyStyle = cinematographyStyle;
        this.script = script;
        this.budgetUsd = budgetUsd;
        this.distributionStrategy = distributionStrategy;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", directorName='" + directorName + '\'' +
                ", cast=" + cast +
                ", cinematographyStyle='" + cinematographyStyle + '\'' +
                ", script='" + (script != null ? "exists" : "none") + '\'' +
                ", budgetUsd=" + budgetUsd +
                ", distributionStrategy='" + distributionStrategy + '\'' +
                '}';
    }

    // Getters if needed, but not strictly required by the prompt
    public String getTitle() { return title; }
    public String getDirectorName() { return directorName; }
    public List<String> getCast() { return cast; }
    public String getCinematographyStyle() { return cinematographyStyle; }
    public String getScript() { return script; }
    public long getBudgetUsd() { return budgetUsd; }
    public String getDistributionStrategy() { return distributionStrategy; }
}
