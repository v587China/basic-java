package com.ultra.java;

import java.lang.reflect.Method;

import org.junit.Test;

import com.ultra.java高级.Person;

public class F002Reflect反射之获取和调用类定义和继承的方法 {

    @Test
    public void testMethod() throws Exception {
        Class clazz = Class.forName("com.java高级.Person");
        // getMethods()获取指定类的所有public方法包括继承的
        Method methods[] = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "   " + method.getReturnType() + "   " + method.getModifiers());
        }
        System.out.println("===================");
        // getgetDeclaredMethods()获取指定类自己声明的所有方法，包括private
        Method methods2[] = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method.getName() + "   " + method.getReturnType() + "   " + method.getModifiers());
        }
        // getMethod(String methodName,Class
        // parameterTypes)获取指定类的public方法(包括继承的)
        // 参数为方法名，和方法参数的Class类型 ,基本数据类型的Class类名为对应的类型.class。例如：int.class
        // Method method=clazz.getMethod("setAge",int.class);
        // getDeclaredMethod(String methodName,Class
        // parameterTypes)获取指定类的自己声明的方法(包括私有的)
        Method privateMethod = clazz.getDeclaredMethod("test");
        Method protectedMethod = clazz.getDeclaredMethod("test2");
        Method defaultMethod = clazz.getDeclaredMethod("test3");
        Method publicMethod = clazz.getDeclaredMethod("test4", String.class, Integer.class);
        // 调用指定方法：invoke(Object obj,Object args)
        // 参数为，哪个对象的方法，及方法实参
        Person p = (Person) clazz.newInstance();
        // private方法调用
        // 调用private方法之前需要设置指定private方法的访问权限为true
        privateMethod.setAccessible(true);
        privateMethod.invoke(p);
        // protected方法调用
        protectedMethod.invoke(p);
        // default方法调用
        defaultMethod.invoke(p);
        // public方法调用
        publicMethod.invoke(p, "范范", 18);

    }

    /**
     * @param className: 某个类的全类名
     * @param methodName: 类的一个方法的方法名. 该方法也可能是私有方法.
     * @param args: 调用该方法需要传入的参数
     * @return: 调用方法后的返回值
     */

    public Object invoke(String className, String methodName, Object... agrs) {
        try {
            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            invoke(obj, methodName, agrs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param obj: 方法执行的那个对象.
     * @param methodName: 类的一个方法的方法名. 该方法也可能是私有方法.
     * @param args: 调用该方法需要传入的参数
     * @return: 调用方法后的返回值
     */

    public Object invoke1(Object obj, String methodName, Object... args) {
        Class para[] = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            para[i] = args[i].getClass();
            System.out.println(para[i].getName());
        }
        Class clazz = obj.getClass();
        try {
            Method method = clazz.getMethod(methodName, para);
            return method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 这一个方法代替上面的两个方法
     * 
     * @param obj: 方法执行的那个对象或者某个类的全类名.
     * @param methodName: 类的一个方法的方法名. 该方法也可能是私有方法.
     * @param args: 调用该方法需要传入的参数
     * @return: 调用方法后的返回值
     */
    public Object invoke(Object obj, String methodName, Object... args) {
        Class clazz = null;
        Class para[] = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            para[i] = args[i].getClass();
            System.out.println(para[i].getName());
        }
        if (obj.getClass().getName().endsWith("String")) {
            try {
                clazz = Class.forName((String) obj);
                try {
                    obj = clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            clazz = obj.getClass();
        }
        try {
            Method method = clazz.getMethod(methodName, para);
            return method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testInvoke() {
        Object className = "com.java高级.Person";
        Object obj = new Person();
        String methodName = "test4";
        // int会被自动封装成Integer类型
        invoke(className, methodName, "宝哥", 21);
        invoke(obj, methodName, "范范", 18);

    }
}
