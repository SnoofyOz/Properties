package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserRequestMapper;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.controller.api.user.models.UserResponseMapper;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.domain.user.User;
import com.flrtt.exp.domain.user.UserName;
import com.flrtt.exp.service.user.UserUseCaseService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserController implements UserInterface {
    UserUseCaseService userUseCaseService;
    UserResponseMapper userResponseMapper;
    UserRequestMapper userRequestMapper;

    @Override
    public List<UserResponse> findByUsername(String username, Pageable pageable) {
        List<User> users = userUseCaseService.findPortalByUsername(new UserName(username));
        return users.stream()
                .map(userResponseMapper::toModels)
                .toList();
    }

    @Override
    public User save(UserRequest userRequest) {
        User req = userRequestMapper.toDto(userRequest);
        return userUseCaseService.createUser(req);
    }

    @Override
    public void update(String id, UserRequest request) {
    }
}
