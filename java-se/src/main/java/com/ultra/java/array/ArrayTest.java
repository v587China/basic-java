package com.ultra.java.array;

import com.ultra.pojo.Chairman;
import com.ultra.pojo.Employee;
import com.ultra.pojo.Manager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据和ArrayList
 *
 * @author fan
 * @date 2019/12/20 20:06
 */
public class ArrayTest {

    @Test
    public void testArrayPolymorphism() {
        Employee[] employees = new Manager[10];
        //存:Employee及其子类
        //取:Employee
    }

    @Test
    public void testCollectionPolymorphism() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Chairman());

    }

}
