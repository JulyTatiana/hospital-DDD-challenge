package com.example.hospital.dietician.values;

import co.com.sofka.domain.generic.Identity;

public class DieticianID extends Identity {
    public DieticianID() {
    }

    private DieticianID(String id) {
        super(id);
    }

    public static DieticianID of(String id) {
        return new DieticianID(id);
    }
}
