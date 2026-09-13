package com.aitu.builder;

import java.util.List;

/**
 * Класс Директора для управления процессом сборки.
 */
public class FilmProductionDirector {
    
    /**
     * Собирает блокбастер (летний хит).
     */
    public Movie produceSummerTentpole(MovieBuilder builder, String title, String directorName, 
                                       List<String> castMembers, long budgetUsd) {
        builder.setTitle(title)
               .setDirector(directorName)
               .setBudget(budgetUsd);
        
        for (String member : castMembers) {
            builder.addCastMember(member);
        }
        
        return builder.build();
    }

    /**
     * Собирает инди-драму (фестивальное кино).
     */
    public Movie produceFestivalDrama(MovieBuilder builder, String title, String directorName, 
                                      String script, long budgetUsd) {
        return builder.setTitle(title)
                      .setDirector(directorName)
                      .setScript(script)
                      .setBudget(budgetUsd)
                      .build();
    }
}
