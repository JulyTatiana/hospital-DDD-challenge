package com.example.hospital.dentist.values;

import co.com.sofka.domain.generic.Identity;

public class DentistID extends Identity {
    public DentistID() {
    }

    private DentistID(String id) {
        super(id);
    }

    public static DentistID of(String id) {
        return new DentistID(id);
    }
}
