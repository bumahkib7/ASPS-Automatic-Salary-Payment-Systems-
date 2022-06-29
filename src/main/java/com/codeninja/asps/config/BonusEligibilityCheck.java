package com.codeninja.asps.config;

import com.codeninja.asps.models.BonusAccordingToEmployeeLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Data


public class BonusEligibilityCheck {
    private final BonusAccordingToEmployeeLevel bonusAccordingToEmployeeLevel;

    public boolean isBonusEligible(int salary) {
        return salary >= bonusAccordingToEmployeeLevel.getBonus();
    }


    public int getBonus() {
        return bonusAccordingToEmployeeLevel.getBonus();
    }
}
