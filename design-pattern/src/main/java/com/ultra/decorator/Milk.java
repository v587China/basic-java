package com.ultra.decorator;

/**
 * 装饰者
 */
public class Milk implements Beverage {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ";condiment milk";
    }

    @Override
    public double price() {
        return beverage.price() + 1;
    }
}
