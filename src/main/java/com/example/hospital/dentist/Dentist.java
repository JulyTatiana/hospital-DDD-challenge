package com.example.hospital.dentist;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dentist.events.*;
import com.example.hospital.dentist.values.*;
import com.example.hospital.dietician.values.Description;
import com.example.hospital.dietician.values.Name;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dentist extends AggregateEvent<DentistID> {
    protected Set<Patient> patientSet;
    protected Map<PatientID, Diet> dietMap;
    protected Name name;

    public Dentist(DentistID entityId, Name name) {
        super(entityId);
        appendChange(new DentistCreated(name)).apply();
    }

    private Dentist(DentistID entityId) {
        super(entityId);
        subscribe(new DentistChange(this));
    }

    public static Dentist from(DentistID dentistID, List<DomainEvent> events) {
        Dentist dentist = new Dentist(dentistID);
        events.forEach(dentist::applyEvent);
        return dentist;
    }

}
