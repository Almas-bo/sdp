package com.aitu.builder;

/**
 * Кастомное исключение конфигурации фильма.
 */
public class InvalidMovieConfigurationException extends RuntimeException {
    public InvalidMovieConfigurationException(String message) {
        super(message);
    }
}
