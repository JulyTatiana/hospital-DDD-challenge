package com.example.hospital.optometry;

import co.com.sofka.domain.generic.EventChange;
import com.example.hospital.optometry.events.*;

import java.util.HashSet;

public class OptometryChange extends EventChange {

    public OptometryChange(Optometry optometry) {
        apply((OptometryCreated event) -> {
            optometry.name = event.getName();
            optometry.serviceSet = new HashSet<>();
            optometry.productSet = new HashSet<>();
        });

    }
}
