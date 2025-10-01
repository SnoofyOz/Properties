package com.flrtt.exp.controller.api.admin;

import com.flrtt.exp.controller.api.user.models.UserModelMapper;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.service.user.UserUseCaseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController implements AdminInterface {
    UserUseCaseService userUseCaseService;
    UserModelMapper userModelMapper;


    @Override
    public List<UserResponse> findAll(String code) {
        List<User> users = userUseCaseService.findAll(code);
        return users.stream()
                .map(userModelMapper::toModels)
                .toList();
    }

    @Override
    public User findById(String id) {

        return userUseCaseService.findById(new UserId(id));
    }

    @Override
    public User save(UserRequest userRequest) {
        User req = userModelMapper.toDto(userRequest);
        return userUseCaseService.createUser(req);
    }

    @Override
    public void update(String id, UserRequest request) {
        User req = userModelMapper.toDto(request);
        userUseCaseService.updateUser(id, req);
    }

    @Override
    public void delete(String id) {
        userUseCaseService.deleteUser(id);
    }

}
