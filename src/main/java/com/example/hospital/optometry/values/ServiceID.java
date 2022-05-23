package com.example.hospital.optometry.values;

import co.com.sofka.domain.generic.Identity;

public class ServiceID extends Identity {
    public ServiceID() {
    }

    private ServiceID(String id) {
        super(id);
    }

    public static ServiceID of(String id) {
        return new ServiceID(id);
    }
}
