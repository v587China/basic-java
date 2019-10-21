package com.ultra.templateMethod;

public class Tea extends Drink {
    @Override
    public void material() {
        System.out.println("原料茶叶...");
    }

    @Override
    public void condiments() {
        System.out.println("佐料蜂蜜...");
    }

    @Override
    public void mail() {
        System.out.println("邮寄...");
    }
}
