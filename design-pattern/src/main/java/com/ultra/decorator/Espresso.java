package com.ultra.decorator;

/**
 * 被装饰者
 */
public class Espresso implements Beverage {

    @Override
    public String getDescription() {
        return "coffee Espresso";
    }

    @Override
    public double price() {
        return 5;
    }
}
