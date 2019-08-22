package com.ultra.java;

import com.ultra.java高级.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class F005Reflect反射之构造函数注解 {

    @Test
    public void testConstructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String className = "com.java高级.Person";
        Class<?> clazz = Class.forName(className);
        Constructor<?>[] constructor = clazz.getConstructors();
        for (Constructor<?> con : constructor) {
            System.out.println(con);
        }
        Constructor<?> con = clazz.getConstructor(String.class, int.class);
        System.out.println(con);
        // Class类型对象通过反射只能调用无参构造函数
        // clazz.newInstance();
        // Constructor类型对象可以调用无参或者有参构造函数
        Person person = (Person) con.newInstance("范范", 18);
        System.out.println(person);
    }
}
