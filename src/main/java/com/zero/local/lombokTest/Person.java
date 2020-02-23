package com.zero.local.lombokTest;

import lombok.*;

/**
 * @author yechangfeng
 * @date 2018/12/10
 */
@Getter
@Setter
@AllArgsConstructor
//@ToString(exclude = "sex")
@ToString(of = {"name","age"})
@EqualsAndHashCode
public class Person {
    private String name;
    private int age;
    private String address;
    private String sex;
}
