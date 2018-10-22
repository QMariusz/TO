package model;

public class Currency {

    private String code;
    private int multiplier;
    private String name;
    private double rate;

    public Currency(String name, int multiplier, String code, double rate) {
        this.name = name;
        this.multiplier = multiplier;
        this.code = code;
        this.rate = rate;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
