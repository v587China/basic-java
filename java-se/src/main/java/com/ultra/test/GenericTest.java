package com.ultra.test;

import com.ultra.pojo.Chairman;
import com.ultra.pojo.Employee;
import com.ultra.pojo.Manager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void testArray() {
        Manager[] managers = new Manager[10];
        Employee[] employees = managers;
        employees[0] = new Employee();//运行期检查,抛异常:java.lang.ArrayStoreException: java.lang.Object
        employees[1] = new Manager();
    }

    @Test
    public void testCollection() {
        List<Manager> managers = new ArrayList<>();
        //List<Object> employees = managers;//Error
        List employees = managers;
        employees.add(1);//运行期没问题,不安全
    }

    /**
     * 子类限定不允许写(可以写null),可以读
     */
    @Test
    public void testGenericExtends() {
        List<? extends Employee> employees = new ArrayList<>();
        employees.add(null);
        //employees.add(1);//编译期报错
        //employees.add(new Chairman());//编译期报错
        //employees.add(new Manager());//编译期报错
        Employee employee = employees.get(0);
    }

    /**
     * 子类限定测试
     */
    @Test
    public void testExtends() {
        List<Manager> managers = new ArrayList<>();
        List<Chairman> chairmen = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        print(managers);
        print(chairmen);
        print(employees);
    }

    private void print(List<? extends Employee> employees) {
    }

    /**
     * 父类限定不允许读,可以写
     */
    @Test
    public void testGenericSuper() {
        List<? super Manager> managers = new ArrayList<>();
        managers.add(new Manager());
        //Manager manager = managers.get(0);//编译期报错
    }
}
