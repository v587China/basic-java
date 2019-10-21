package com.ultra.templateMethod;

public class Coffee extends Drink {
    @Override
    public void material() {
        System.out.println("原料咖啡...");
    }

    @Override
    public void condiments() {
        System.out.println("佐料白糖...");
    }
}
