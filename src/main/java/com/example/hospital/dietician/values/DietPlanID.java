package com.example.hospital.dietician.values;

import co.com.sofka.domain.generic.Identity;

public class DietPlanID extends Identity {
    public DietPlanID() {
    }

    private DietPlanID(String id) {
        super(id);
    }

    public static DietPlanID of(String id) {
        return new DietPlanID(id);
    }
}
