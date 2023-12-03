package com.example.fitlog.domain.user.presentation.dto.response;

import com.example.fitlog.domain.user.domain.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {

    private final int age;
    private final Double weight;
    private final Double height;
}