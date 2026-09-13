package com.aitu.builder;

import java.util.List;

/**
 * Интерфейс строителя фильма (fluent API).
 */
public interface MovieBuilder {
    MovieBuilder setTitle(String title);
    MovieBuilder setDirector(String directorName);
    MovieBuilder addCastMember(String castMember);
    MovieBuilder setCinematography(String cinematographyStyle);
    MovieBuilder setScript(String script);
    MovieBuilder setBudget(long budgetUsd);
    Movie build();
}
