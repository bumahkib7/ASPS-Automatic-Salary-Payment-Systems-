package com.codeninja.asps.models;

public enum BonusAccordingToEmployeeLevel {
JUNIOR(5000),
    MIDDLE(10000),
    SENIOR(15000);

    private int bonus;

    BonusAccordingToEmployeeLevel(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
