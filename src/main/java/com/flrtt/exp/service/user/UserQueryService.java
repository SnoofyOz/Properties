package com.flrtt.exp.service.user;


import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.dto.user.UserName;
import com.flrtt.exp.repository.database.user.UserEntity;
import com.flrtt.exp.repository.database.user.UserMapper;
import com.flrtt.exp.repository.database.user.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserQueryService {
    UserRepository userRepository;
    UserMapper userMapper;
    @Query
    public User findById(UserId userId) {
        UserEntity entity = userRepository.findById(userId.value())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(entity);
    }
    public User findByUsername(UserName username) {
        UserEntity entity = userRepository.findByUsername(username.username())
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
