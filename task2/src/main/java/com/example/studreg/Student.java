package com.example.studreg;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@Data
public class Student {

    private UUID id;

    private String firstName;

    private String lastName;

    private int age;

}
