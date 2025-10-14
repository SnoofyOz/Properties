package com.flrtt.exp.service.user;


import com.flrtt.exp.domain.user.User;
import com.flrtt.exp.domain.user.UserId;
import com.flrtt.exp.domain.user.UserName;
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
    public List<User> findPortalByUsername(UserName username){
        List<UserRepository.UserProjection> userDTOs = userRepository.findPortalByUsername(username.username());
        return userDTOs.stream()
                .map(user -> new User(
                        user.getUserId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole(),
                        user.getPropertyId(),
                        user.getPropertyName(),
                        user.getPortalId(),
                        user.getPortalName()
                ))
                .toList();
    }
}
