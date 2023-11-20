package com.example.fitlog.domain.auth.exception;

import global.error.CustomException;
import global.error.ErrorCode;

public class InvalidRefreshTokenException extends CustomException {
    public static final CustomException EXCEPTION =
            new InvalidRefreshTokenException();

    private InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN);
    }
}