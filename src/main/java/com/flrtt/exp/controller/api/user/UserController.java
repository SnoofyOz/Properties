package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserRequestMapper;
import com.flrtt.exp.controller.api.user.models.UserResponseMapper;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserName;
import com.flrtt.exp.service.user.UserUseCaseService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserController implements UserApi {
    UserUseCaseService userUseCaseService;
    UserResponseMapper userResponseMapper;
    UserRequestMapper userRequestMapper;

    @Override
    public User findByUsername(String username) {
        return userUseCaseService.findByUsername(new UserName(username));
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
