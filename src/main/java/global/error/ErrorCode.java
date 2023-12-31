package global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    PASSWORD_MIS_MATCH(401, "Password Mis Match"),
    INVALID_REFRESH_TOKEN(401, "Invalid Refresh Token"),

    USER_EXIST(409, "User Exist"),
    USER_NOT_FOUND(404, "User Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}