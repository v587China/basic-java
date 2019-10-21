package com.ultra.templateMethod;

public abstract class Drink {

    /**
     * 算法步骤:包含共同和不同方法,共同方法直接实现,不同方法为抽象
     */
    public void make() {

        boil();

        material();

        condiments();

        pack();

        //空实现方法,供子类定制个性化
        mail();
    }

    private void boil() {
        System.out.println("把水烧开...");
    }

    public abstract void material();

    public abstract void condiments();

    public void pack() {
        System.out.println("打包...");
    }


    public void mail() {
    }

}
