package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserModelMapper;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.repository.database.user.UserMapper;
import com.flrtt.exp.repository.database.user.UserRepository;
import com.flrtt.exp.service.user.UserUseCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserInterface {
    private final UserUseCaseService userUseCaseService;
    private final UserMapper userMapper;
    private final UserModelMapper userModelMapper;

    @Override
    public User findById(String id) {
        return userUseCaseService.findById(new UserId(id));
    }

    @Override
    public User save(UserRequest userRequest) {
        return null;
    }

    @Override
    public void update(String id, UserRequest request) {
    }

}
