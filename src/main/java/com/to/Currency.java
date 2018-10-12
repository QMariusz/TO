package com.to;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class Currency {

    private String code;
    private int multiplier;
    private String name;
    private double rate;

    public double getMultiplier() {
        return multiplier;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
