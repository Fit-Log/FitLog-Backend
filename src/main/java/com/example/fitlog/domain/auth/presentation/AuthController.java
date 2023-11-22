package com.example.fitlog.domain.auth.presentation;

import com.example.fitlog.domain.auth.presentation.dto.response.TokenResponse;
import com.example.fitlog.domain.auth.service.LogoutService;
import com.example.fitlog.domain.auth.service.ReissueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final ReissueService reissueService;
    private final LogoutService logoutService;

    @PatchMapping("/token")
    public TokenResponse reissue(String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/token")
    public void logout() {
        logoutService.execute();
    }
}
