package com.amrut.prabhu.reactiveprogramming;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Person {

    @Id
    private String id;
    private String name;

}
