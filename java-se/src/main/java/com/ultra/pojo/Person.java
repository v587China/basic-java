package com.ultra.pojo;

import lombok.*;

/**
 * @author admin
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private Integer no;

    public Person(String name) {
        this.name = name;
    }

    public static Person build() {
        return new Person("default", 1);
    }
}
