package com.ultra.java;

import com.ultra.pojo.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class A040Lambda {

    // lambda标准语法示例(String str1,String str2)->{//do somethings return}
    // 简写形式:
    // 类型可推导出可省略(str1,str2)->{//do somethings return}
    // 只有一个参数括号可省略
    // 执行的代码只有一行{return}可省略,且不用;结尾
    // 没有参数的()不能省略()->{}
    @Test
    public void interfaceGrammar() {
        String[] strings = {"q", "w", "2", "4", "f", "y", "e", "w"};
        Arrays.sort(strings, (String str1, String str2) -> str1.compareTo(str2));
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void methodGrammar() {
        Person[] persons = new Person[10];
        Arrays.sort(persons, Comparator.comparing(Person::getName));
        Arrays.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getId));
        Arrays.sort(persons, Comparator.comparing(Person::getName, (s, t) -> Integer.compare(s.length(), t.length())));
    }

    @Test
    public void map() {
        Map<String, String> maps = new HashMap<>();
        maps.put("a", "AA");
        maps.put("b", "BB");
        maps.put("c", "CC");
        maps.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }
}
