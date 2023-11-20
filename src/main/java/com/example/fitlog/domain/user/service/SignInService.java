package com.example.fitlog.domain.user.service;

import com.example.fitlog.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fitlog.domain.user.domain.User;
import com.example.fitlog.domain.user.domain.repository.UserRepository;
import com.example.fitlog.domain.user.exception.PasswordMisMatchException;
import com.example.fitlog.domain.user.exception.UserNotFoundException;
import com.example.fitlog.domain.user.presentation.dto.request.SignInRequest;
import global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}