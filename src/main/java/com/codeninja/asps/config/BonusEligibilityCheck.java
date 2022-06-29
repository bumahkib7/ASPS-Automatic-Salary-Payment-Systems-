package com.codeninja.asps.config;

import com.codeninja.asps.models.BonusAccordingToEmployeeLevel;
import org.springframework.stereotype.Component;

@Component
public class BonusEligibilityCheck {
    private final BonusAccordingToEmployeeLevel bonusAccordingToEmployeeLevel;

    public BonusEligibilityCheck(BonusAccordingToEmployeeLevel bonusAccordingToEmployeeLevel) {
        this.bonusAccordingToEmployeeLevel = bonusAccordingToEmployeeLevel;
    }

    public boolean isBonusEligible(int salary) {
        return salary >= bonusAccordingToEmployeeLevel.getBonus();
    }


    public int getBonus() {
        return bonusAccordingToEmployeeLevel.getBonus();
    }
}
