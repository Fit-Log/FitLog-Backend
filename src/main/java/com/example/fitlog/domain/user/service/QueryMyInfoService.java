package com.example.fitlog.domain.user.service;

import com.example.fitlog.domain.user.domain.User;
import com.example.fitlog.domain.user.facade.UserFacade;
import com.example.fitlog.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryUserInfoResponse getMyInfo() {
        User user = userFacade.getCurrentUser();

        return QueryUserInfoResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .year(user.getYear())
                .month(user.getMonth())
                .day(user.getDay())
                .weight(user.getWeight())
                .height(user.getHeight())
                .gender(user.getGender())
                .build();
    }
}