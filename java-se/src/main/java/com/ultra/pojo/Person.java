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
    private Integer id;

    public Person(String name) {
        this.name = name;
    }
}
