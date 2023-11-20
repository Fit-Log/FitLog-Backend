package com.example.fitlog.domain.user.presentation.dto.response;

import com.example.fitlog.domain.user.domain.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {

    private final String name;
    private final int age;
    private final int year;
    private final int month;
    private final int day;
    private final Double weight;
    private final Double height;
    private final Gender gender;
}