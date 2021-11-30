package com.abcool.entity;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class SeatBelt {
    @Enumerated(EnumType.STRING)
    private SeatBeltModel seatBeltModel;
    public void close(){

    }
    public void open(){}
}
