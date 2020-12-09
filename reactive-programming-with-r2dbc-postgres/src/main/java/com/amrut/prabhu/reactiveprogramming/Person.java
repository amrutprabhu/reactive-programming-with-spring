package com.amrut.prabhu.reactiveprogramming;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id
    private Integer id;
    private String name;

}
