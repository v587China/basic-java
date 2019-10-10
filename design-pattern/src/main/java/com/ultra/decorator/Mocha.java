package com.ultra.decorator;

/**
 * 装饰者
 */
public class Mocha implements Beverage {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ";condiment mocha";
    }

    @Override
    public double price() {
        return beverage.price() + 2;
    }
}
