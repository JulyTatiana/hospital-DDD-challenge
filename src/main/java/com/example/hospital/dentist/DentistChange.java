package com.example.hospital.dentist;

import co.com.sofka.domain.generic.EventChange;
import com.example.hospital.dentist.events.*;

import java.util.HashMap;
import java.util.HashSet;

public class DentistChange extends EventChange {
    public DentistChange(Dentist dentist) {
        apply((DentistCreated event) -> {
            dentist.name = event.getName();
            dentist.patientSet = new HashSet<>();
            dentist.dietMap = new HashMap<>();
        });
    }
}
