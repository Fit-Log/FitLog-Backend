package com.example.fitlog.domain.auth.service;

import com.example.fitlog.domain.auth.domain.RefreshToken;
import com.example.fitlog.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.fitlog.domain.auth.exception.InvalidRefreshTokenException;
import com.example.fitlog.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fitlog.domain.user.exception.RefreshTokenNotFoundException;
import global.security.jwt.JwtProperties;
import global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReissueService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse reissue(String refreshToken) {
        String parseToken = jwtTokenProvider.parseToken(refreshToken);
        if (parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }
        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getAccountId());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String newAccessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getAccountId());

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}