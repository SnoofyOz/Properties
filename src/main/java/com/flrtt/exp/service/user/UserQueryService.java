package com.flrtt.exp.service.user;


import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.dto.user.UserName;
import com.flrtt.exp.repository.database.user.UserEntity;
import com.flrtt.exp.repository.database.user.UserEntityMapper;
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
    UserEntityMapper mapper;
    @Query
    public User findById(UserId userId) {
        UserEntity entity = userRepository.findById(userId.value())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapper.toDto(entity);
    }
    public User findByUsername(UserName username) {
        UserEntity entity = userRepository.findByUsername(username.username())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapper.toDto(entity);
    }
    public List<User> findAll() {
        List<UserEntity> entities = userRepository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .toList();
    }
    public List<User> findByUsernameDetails(){
        List<User> userDTO = userRepository.findByUsernameDetails();
        return userDTO.stream()
                .toList();
    }
}
