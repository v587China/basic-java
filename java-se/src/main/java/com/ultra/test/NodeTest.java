package com.ultra.test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NodeTest {
    @Test
    public void addTest() {
        List<String> strings = new LinkedList<>();
        strings.add("AA");
        strings.add("BB");
        ListIterator<String> iterator = strings.listIterator();
        iterator.add("CC");
        iterator.add("DD");
        String str1 = iterator.next();
        //AA
        System.out.println(str1);
        //BB
        String str2 = iterator.next();
        System.out.println(str2);
        iterator.add("EE");
        iterator.add("FF");
        //CC DD AA BB EE FF
        System.out.println(strings);
    }
}
