package com.flrtt.exp.service.user;


import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.dto.user.UserName;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserUseCaseService {
    UserCommandService commandService;
    UserQueryService queryService;

    @Transactional
    public User createUser(User request) {
        return commandService.create(request);
    }

    @Transactional
    public void updateUser(String id, User request) {
        commandService.updateUser(id, request);
    }

    public User findById(UserId id) {
        return queryService.findById(id);
    }

    public User findByUsername(UserName username) {
        return queryService.findByUsername(username);
    }

    public List<User> findAll(String code) {
        return queryService.findAll();
    }

    @Transactional
    public void deleteUser(String id) {
        commandService.delete(id);
    }
}
