package com.abcool.control;

import com.abcool.entity.Color;
import com.abcool.utils.Electric;

import javax.enterprise.inject.Produces;

public class DefaultColorExposure {

    @Produces
    @Electric
    public Color exposeDefaultColor(){
        //..... some logic
        return Color.BLUE;
    }
}
