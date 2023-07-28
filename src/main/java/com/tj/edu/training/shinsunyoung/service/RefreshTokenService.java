package com.tj.edu.training.shinsunyoung.service;

import com.tj.edu.training.shinsunyoung.model.RefreshToken;
import com.tj.edu.training.shinsunyoung.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(
                () -> new IllegalArgumentException("Unexpected Token"));
    }
}
