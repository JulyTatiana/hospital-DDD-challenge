package com.example.hospital.optometry.values;

import co.com.sofka.domain.generic.Identity;

public class OptometryID extends Identity {
    public OptometryID() {
    }

    private OptometryID(String id) {
        super(id);
    }

    public static OptometryID of(String id) {
        return new OptometryID(id);
    }
}
