package com.example.fitlog.domain.user.service;

import com.example.fitlog.domain.user.domain.User;
import com.example.fitlog.domain.user.domain.repository.UserRepository;
import com.example.fitlog.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserWithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void deleteUser() {
        User user = userFacade.getCurrentUser();
        userRepository.delete(user);
    }
}