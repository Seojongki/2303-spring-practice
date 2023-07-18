package com.tj.edu.practice5.jpa.service;

import com.tj.edu.practice5.jpa.model.Users;
import com.tj.edu.practice5.jpa.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public void put(){
        Users user = Users.builder()
                .name("이순신")
                .build();

        usersRepository.save(user);
    }
}
