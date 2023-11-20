package com.example.fitlog.domain.user.presentation.dto.request;

import com.example.fitlog.domain.user.domain.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotNull
    @Size(min = 7, max = 20)
    @NotEmpty(message = "Null, 공백, 띄어쓰기를 허용하지 않으며, 7자 이상 20자 이하여야 합니다.")
    private String accountId;

    @NotNull
    @Size(min = 8, max = 20)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\\\W)(?=\\\\S+$).{7,20}",
            message = "비밀번호는 7~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @NotNull(message = "최대 5자를 허용하며, 필수 항목입니다.")
    private String name;

    @NotNull(message = "최대 3자를 허용하며, 필수 항목입니다.")
    private int age;

    @NotNull(message = "최대 4자를 허용하며, 필수 항목입니다.")
    private int year;

    @NotNull(message = "필수 항목입니다.")
    private int month;

    @NotNull(message = "필수 항목입니다.")
    private int day;

    @NotNull(message = "최대 5자를 허용하며, 필수 항목입니다.")
    private Double weight;

    @NotNull(message = "최대 5자를 허용하며, 필수 항목입니다.")
    private Double height;

    @NotNull(message = "성별은 필수 선택해야할 항목입니다.")
    private Gender gender;
}