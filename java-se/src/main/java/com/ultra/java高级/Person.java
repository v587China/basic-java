package com.ultra.java高级;

public class Person {

    public String sex;
    protected String chara;
    String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void test() {
        System.out.println("私有方法被调用");
    }

    protected void test2() {

        System.out.println("protected方法被调用");
    }

    void test3() {
        System.out.println("默认的修饰符方法被调用");

    }

    public void test4(String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
    }

    public void printPerson(Person person) {
        System.out.println(person);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
