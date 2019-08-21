package com.ultra.java;

import java.io.InputStream;

import org.junit.Test;

import com.ultra.java高级.Person;

;

public class F001Reflect反射之Class和ClassLoader {
    /**
     * 关于 Class: 1. Class 是一个类 2. 对象照镜子后可以得到的信息：某个类的数据成员名、方法和构造器、 某个类到底实现了哪些接口。 3.
     * 对于每个类而言，JRE 都为其保留一个不变的 Class 类型的对象。 一个 Class 对象包含了特定某个类的有关信息。 4. Class
     * 对象只能由系统建立对象 5. 一个类在 JVM 中只会有一个Class实例
     * 
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取指定类的Class类===>目的是为了获取指定类的Class类的实例，
        // 通过它的newInstance()方法调用指定类的无参构造函数创建指定类的对象
        // 其次
        // 1. 指定类的类名.class
        Class cl1 = Person.class;
        ClassLoader classLoader = cl1.getClassLoader();
        System.out.println(cl1);
        Object obj = new Person();
        // 多态情况下可能会使用，有父类的引用指向子类对象
        // 2. 指定类的一个对象引用.getClass()
        Class cl2 = obj.getClass();
        System.out.println(cl2);
        // 用的最多
        // 3. Class.forName("全路径+类名(不带后缀名.java)")
        Class cl3 = Class.forName("com.java高级.Person");
        System.out.println(cl3);

        // 利用 Class 对象的 newInstance() 方法来创建类的一个对象.
        // 实际调用的是类的那个 无参数的 构造器!
        // 一般地, 一个类若声明了带参数的构造器, 也要声明一个无参数的构造器.
        Person p2 = (Person) cl3.newInstance();
        System.out.println(p2);
    }

    @Test
    public void testClassLoader() throws ClassNotFoundException {
        // 1. 获取一个系统的类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println("0  " + classLoader);

        // 2. 获取系统类加载器的父类加载器.
        classLoader = classLoader.getParent();
        System.out.println("1  " + classLoader);

        // 3. 获取扩展类加载器的父类加载器.
        classLoader = classLoader.getParent();
        System.out.println("2  " + classLoader);

        // 4. 测试当前类由哪个类加载器进行加载:
        classLoader = Class.forName("com.java高级.Person").getClassLoader();
        System.out.println("3  " + classLoader);

        // 5. 测试 JDK 提供的 Object 类由哪个类加载器负责加载
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("4  " + classLoader);

        // 6*. 关于类加载器的一个主要方法.
        // 调用AppClassLoader的 getResourceAsStream 获取类路径下的文件对应的输入流.
        // 不能调用ExtClassLoader的 getResourceAsStream来获取
        InputStream in = null;
        in =
                // 参数是资源名称
                this.getClass().getClassLoader().getResourceAsStream("db.properties");
        // 此方法委托此对象的类加载器,如果此对象通过引导类加载器加载，则此方法将委托给
        // ClassLoader.getSystemResourceAsStream(java.lang.String)。 参数是绝对资源名
        // this.getClass().getResourceAsStream("/db.properties");
        // ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
        System.out.println("5  " + in);
        System.out.println("6  " + this.getClass().getClassLoader());
        // new FileInputStream("db.properties");
        Class cl = Class.forName("com.java高级.Person");
        // 获取某个类的Class类的加载器
        ClassLoader cLoader = cl.getClassLoader();
        System.out.println("7  " + cLoader);
        System.out.println("8  " + cLoader.getParent());
        System.out.println("9  " + cLoader.getParent().getParent());
    }
}
