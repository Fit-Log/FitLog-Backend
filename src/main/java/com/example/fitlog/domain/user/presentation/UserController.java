package com.example.fitlog.domain.user.presentation;

import com.example.fitlog.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fitlog.domain.user.presentation.dto.request.SignInRequest;
import com.example.fitlog.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.fitlog.domain.user.presentation.dto.response.QueryUserInfoResponse;
import com.example.fitlog.domain.user.service.QueryMyInfoService;
import com.example.fitlog.domain.user.service.SignInService;
import com.example.fitlog.domain.user.service.UserSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final QueryMyInfoService queryMyInfoService;
    private final SignInService signInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.signUp(request);
    }

    @PostMapping("/token")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return signInService.signIn(request);
    }

    @GetMapping
    public QueryUserInfoResponse getMyInfo() {
        return queryMyInfoService.getMyInfo();
    }
}