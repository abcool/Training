package com.abcool.events;

public class CarCreated {

    private final String identifier;

    public CarCreated(String identifier) {
        this.identifier=identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
