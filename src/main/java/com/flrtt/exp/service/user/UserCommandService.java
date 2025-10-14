package com.flrtt.exp.service.user;


import com.flrtt.exp.domain.user.User;
import com.flrtt.exp.repository.database.user.UserEntity;
import com.flrtt.exp.repository.database.user.UserEntityMapper;
import com.flrtt.exp.repository.database.user.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserCommandService {
    UserRepository repository;
    UserEntityMapper mapper;
    PasswordEncoder passwordEncoder;

    public User save(User request) {
        UserEntity entity = mapper.toEntity(request);
        String encodedPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        entity.setRole("USER");
        return mapper.toDto(repository.save(entity));
    }

    public void update(String userId, User request) {
        UserEntity entity = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        entity.setPassword(request.password());
        String encodedPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        mapper.toDto(repository.save(entity));
    }

    public void delete(String userId) {
        repository.findById(userId).ifPresent(repository::delete);
    }
}