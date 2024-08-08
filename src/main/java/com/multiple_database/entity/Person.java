package com.multiple_database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "PERSON")
public class Person {
    @Id
    private Long id;
    private String name;
    private String location;
    private Date birthDate;
}