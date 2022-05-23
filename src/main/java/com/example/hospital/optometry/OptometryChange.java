package com.example.hospital.optometry;

import co.com.sofka.domain.generic.EventChange;
import com.example.hospital.optometry.events.*;

import java.util.HashSet;

public class OptometryChange extends EventChange {

    public OptometryChange(Optometry frontDesk) {
        apply((OptometryCreated event) -> {
            frontDesk.name = event.getName();
            frontDesk.serviceSet = new HashSet<>();
            frontDesk.productSet = new HashSet<>();
        });

    }
}
