package com.example.fitlog.domain.user.service;

import com.example.fitlog.domain.user.domain.User;
import com.example.fitlog.domain.user.domain.repository.UserRepository;
import com.example.fitlog.domain.user.exception.UserExistException;
import com.example.fitlog.domain.user.presentation.dto.request.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserSignUpRequest request) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                        .name(request.getName())
                        .age(request.getAge())
                        .year(request.getYear())
                        .month(request.getMonth())
                        .day(request.getDay())
                        .weight(request.getWeight())
                        .height(request.getHeight())
                        .build()
        );
    }
}