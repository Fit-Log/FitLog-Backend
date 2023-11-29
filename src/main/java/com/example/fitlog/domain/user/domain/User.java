package com.example.fitlog.domain.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 7, max = 20)
    private String accountId;


    @Size(min = 8, max = 16)
    private String password;

    @NotNull
    private String name;

    @NotNull
    private int age;

    @NotNull
    private int year;

    @NotNull
    private int month;

    @NotNull
    private int day;

    @NotNull
    private Double weight;

    @NotNull
    private Double height;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder
    public User(String accountId, String password, String name, int age, int year, int month, int day, Double weight, Double height, Gender gender) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.age = age;
        this.year = year;
        this.month = month;
        this.day = day;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    public void modifyInfo(Double weight, Double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }
}