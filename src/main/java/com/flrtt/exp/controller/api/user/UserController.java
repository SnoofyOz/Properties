package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserModelMapper;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserName;
import com.flrtt.exp.service.user.UserUseCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserInterface {
    private final UserUseCaseService userUseCaseService;
    private final UserModelMapper userModelMapper;

    @Override
    public User findByUsername(String username) {
        return userUseCaseService.findByUsername(new UserName(username));
    }

    @Override
    public User save(UserRequest userRequest) {
        User req = userModelMapper.toDto(userRequest);
        return userUseCaseService.createUser(req);
    }

    @Override
    public void update(String id, UserRequest request) {
    }
}
