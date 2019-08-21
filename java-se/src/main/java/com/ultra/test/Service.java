package com.ultra.test;


import com.ultra.pojo.Person;

public interface Service {
    void addPerson(Person person);

    void delPerson(Integer id);

    void updPerson(Person person);
}
