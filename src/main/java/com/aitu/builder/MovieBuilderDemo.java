package com.aitu.builder;

import java.util.List;

/**
 * Главный класс для демонстрации работы паттерна Builder.
 */
public class MovieBuilderDemo {
    public static void main(String[] args) {
        demonstrateDirectBlockbusterAssembly();
        System.out.println("-----------------------------------");
        demonstrateDirectIndieAssembly();
        System.out.println("-----------------------------------");
        demonstrateDirectorReusableConfigurations();
        System.out.println("-----------------------------------");
        demonstrateValidationFailure();
    }

    private static void demonstrateDirectBlockbusterAssembly() {
        System.out.println("Demonstrating Direct Blockbuster Assembly:");
        Movie blockbuster = new BlockbusterMovieBuilder()
                .setTitle("Interstellar 2")
                .setDirector("Christopher Nolan")
                .addCastMember("Matthew McConaughey")
                .addCastMember("Anne Hathaway")
                .addCastMember("Jessica Chastain")
                .setBudget(165_000_000L)
                .build();
        System.out.println(blockbuster);
    }

    private static void demonstrateDirectIndieAssembly() {
        System.out.println("Demonstrating Direct Indie Assembly:");
        Movie indie = new IndieFilmMovieBuilder()
                .setTitle("Moonlight")
                .setDirector("Barry Jenkins")
                .setScript("A story of human connection")
                .setBudget(1_500_000L)
                .build();
        System.out.println(indie);
    }

    private static void demonstrateDirectorReusableConfigurations() {
        System.out.println("Demonstrating Director Reusable Configurations:");
        FilmProductionDirector director = new FilmProductionDirector();
        
        // Blockbuster via Director
        Movie tentpole = director.produceSummerTentpole(
                new BlockbusterMovieBuilder(),
                "Avengers: Endgame",
                "Russo Brothers",
                List.of("Robert Downey Jr.", "Chris Evans", "Scarlett Johansson"),
                356_000_000L
        );
        System.out.println("Tentpole: " + tentpole);

        // Indie via Director
        Movie drama = director.produceFestivalDrama(
                new IndieFilmMovieBuilder(),
                "The Whale",
                "Darren Aronofsky",
                "Emotional chamber drama",
                3_000_000L
        );
        System.out.println("Drama: " + drama);
    }

    private static void demonstrateValidationFailure() {
        System.out.println("Demonstrating Validation Failure (Low Budget Blockbuster):");
        try {
            new BlockbusterMovieBuilder()
                    .setTitle("Cheap Blockbuster")
                    .setDirector("John Doe")
                    .addCastMember("A")
                    .addCastMember("B")
                    .addCastMember("C")
                    .setBudget(1_000_000L) // Too low for a blockbuster
                    .build();
        } catch (InvalidMovieConfigurationException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
