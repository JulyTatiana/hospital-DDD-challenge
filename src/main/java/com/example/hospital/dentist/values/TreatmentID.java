package com.example.hospital.dentist.values;

import co.com.sofka.domain.generic.Identity;

public class TreatmentID extends Identity {
    public TreatmentID() {
    }

    private TreatmentID(String id) {
        super(id);
    }

    public static TreatmentID of(String id) {
        return new TreatmentID(id);
    }
}
