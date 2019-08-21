package com.ultra.java;

import java.lang.reflect.Field;

import org.junit.Test;

import com.ultra.java高级.Student;

public class F004Reflect反射之获取属性名值设置属性 {
    @Test
    public void testGetFileds() throws Exception {
        String className = "com.java高级.Student";
        Class clazz = Class.forName(className);
        // getFields()：获取指定类的所有public属性(包括继承的)
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.print(field.getName() + "  ");
            // 字段访问修饰符的int类型
            System.out.print(field.getModifiers() + "  ");
            // 字段的声明类型
            System.out.println(field.getGenericType());
        }
        // getDeclaredFields():获取指定类的在本类中声明的所有属性(包括私有的)
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.print(field.getName() + "  ");
            System.out.print(field.getModifiers() + "  ");
            System.out.println(field.getGenericType());
        }
        Student stu = new Student("范范", 18);
        stu.id = "101210";
        // stu.score="100";
        // stu.course="数学";
        stu.sex = "男";
        // get(Object obj):获取指定对象指定属性的值(只能是公共的包括父类的)
        Object id = clazz.getField("id").get(stu);
        Object sex = clazz.getField("sex").get(stu);
        System.out.println(id);
        System.out.println(sex);
        // 获取指定类的指定属性(只能是本类声明的包括私有的)
        Field field = clazz.getDeclaredField("grade");
        // 获取、设置私有属性之前需要先设置它的访问权限为true
        field.setAccessible(true);
        Object grade = field.get(stu);
        System.out.println(grade);
        // 设置指定对象的指定属性的值
        // 如果前面已经设置过字段的可访问权限，这里不需要重复设置，反之则需要
        // field.setAccessible(true);
        field.set(stu, 19);
        System.out.println(field.get(stu));
    }
}
