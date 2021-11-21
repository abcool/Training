package com.abcool.events;

import javax.enterprise.event.Observes;

public class CarCreationListener {

    public void onCarCreation(@Observes CarCreated carCreated){
        //.........
        System.out.println("New Car Created with id: " + carCreated.getIdentifier());
    }
}
