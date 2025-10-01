package com.flrtt.exp.service.user;


import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.repository.database.user.UserEntity;
import com.flrtt.exp.repository.database.user.UserMapper;
import com.flrtt.exp.repository.database.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User findById(UserId userId) {
        UserEntity entity = userRepository.findById(userId.value())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(entity);
    }
    public List<User> findAll() {
        List<UserEntity> entities = userRepository.findAll();
        return entities.stream()
                .map(userMapper::toDTO)
                .toList();
    }
}
