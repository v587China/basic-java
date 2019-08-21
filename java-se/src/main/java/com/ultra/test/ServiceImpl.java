package com.ultra.test;


import com.ultra.pojo.Person;

import java.util.HashMap;
import java.util.Map;

public class ServiceImpl implements Service {
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    public ServiceImpl() {
        persons.put(1001, new Person("AA", 1001));
        persons.put(1002, new Person("BB", 1002));
    }

    @Override
    public void addPerson(Person person) {
        persons.put(person.getId(), person);
    }

    @Override
    public void delPerson(Integer id) {
        if (id.equals(1001)) {
            throw new RuntimeException("不能删除此人信息");
        }
        persons.remove(id);
    }

    @Override
    public void updPerson(Person person) {
        persons.put(person.getId(), person);
    }

    public static Map<Integer, Person> getPersons() {
        return persons;
    }
}
