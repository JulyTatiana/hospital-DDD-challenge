package com.example.hospital.dentist;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.dentist.values.*;


import java.util.Objects;

public class Patient extends Entity<PatientID> {

    protected Name name;
    protected Description description;
    protected TreatmentType treatmentType;
    protected ContactNumber contactNumber;


    public Patient(PatientID entityId, Name name, ContactNumber contactNumber) {
        super(entityId);
        this.name = name;
        this.contactNumber = contactNumber;

    }

    public Name name() {
        return name;
    }

    public Description description() {
        return description;
    }

    public TreatmentType treatmentType() {
        return treatmentType;
    }

    public ContactNumber contactNumber() {
        return contactNumber;
    }
}
