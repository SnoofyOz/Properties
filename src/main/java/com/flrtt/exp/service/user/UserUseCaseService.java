package com.flrtt.exp.service.user;


import com.flrtt.exp.domain.user.User;
import com.flrtt.exp.domain.user.UserId;
import com.flrtt.exp.domain.user.UserName;
import lombok.AccessLevel;
import org.springframework.transaction.annotation.Transactional;
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
        return commandService.save(request);
    }

    @Transactional
    public void updateUser(String id, User request) {
        commandService.update(id, request);
    }

    @Transactional
    public void deleteUser(String id) {
        commandService.delete(id);
    }

    @Transactional(readOnly = true)
    public User findById(UserId id) {
        return queryService.findById(id);
    }

    @Transactional(readOnly = true)
    public User findByUsername(UserName username) {
        return queryService.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(String code) {
        return queryService.findAll();
    }

    @Transactional(readOnly = true)
    public List<User> findPortalByUsername(UserName username) {
        return queryService.findPortalByUsername(username);
    }
}
