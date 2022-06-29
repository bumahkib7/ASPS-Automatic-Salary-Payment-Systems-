package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public enum BonusAccordingToEmployeeLevel {
JUNIOR(5000),
    MIDDLE(10000),
    SENIOR(15000);

    private final int bonus;

    @Bean
    public BonusAccordingToEmployeeLevel getBonusAccordingToEmployeeLevel() {
        return this;
    }


    public int getBonus() {
        return bonus;
    }
}
