package com.ultra.java;

import com.ultra.pojo.Person;

/**
 * @version 6.0
 * @Description: java方法参数是值传递
 * @date 2019年8月2日 下午1:24:48
 */
public class A030方法参数值传递 {

    public static void main(String[] args) {
        // 一个方法不能修改一个基本数据类型的参数(即数值型或布尔型)
        // 基本数据类型:值传递证明
        int a = 10;
        doubleInt(a);
        System.out.println(a);

        // 对象的参数状态可以被改变
        Person person = new Person("s", 1);
        doublePersonName(person);
        System.out.println(person);

        // 一个方法不能让对象参数引用一个新的对象
        // 非基本数据类型:值传递证明
        String s1 = "s1";
        String s2 = "s2";
        swap(s1, s2);
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
    }

    private static void doubleInt(int i) {
        i = 2 * i;
    }

    private static void doublePersonName(Person person) {
        person.setName(person.getName() + person.getName());
    }

    private static void swap(String s1, String s2) {
        String temp = s1;
        s1 = s2;
        s2 = temp;
    }
}
