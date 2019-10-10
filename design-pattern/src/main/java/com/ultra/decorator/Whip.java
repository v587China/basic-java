package com.ultra.decorator;

public class Whip implements Beverage {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ";condiment Whip";
    }

    @Override
    public double price() {
        return beverage.price() + 3;
    }
}
