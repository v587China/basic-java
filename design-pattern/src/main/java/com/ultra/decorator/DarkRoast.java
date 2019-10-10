package com.ultra.decorator;

/**
 * 被装饰者
 */
public class DarkRoast implements Beverage {

    @Override
    public String getDescription() {
        return "coffee DarkRoast";
    }

    @Override
    public double price() {
        return 10;
    }
}
