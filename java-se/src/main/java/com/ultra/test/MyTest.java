package com.ultra.test;

import com.ultra.pojo.Person;
import org.junit.Test;

public class MyTest {

    @Test
    public void testProxy() {
        MyProxy myProxy = new MyProxy(new ServiceImpl());
        Service proxy = (Service) myProxy.getServiceProxy();
        System.out.println(ServiceImpl.getPersons());
        proxy.addPerson(new Person("EE", 1005));
        System.out.println(ServiceImpl.getPersons());
        proxy.delPerson(1005);
        System.out.println(ServiceImpl.getPersons());
        proxy.updPerson(new Person("FF", 1001));
        System.out.println(ServiceImpl.getPersons());
        proxy.delPerson(1001);
        System.out.println(ServiceImpl.getPersons());
    }
}
