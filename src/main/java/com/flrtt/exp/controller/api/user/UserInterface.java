package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/v1/api/users")
public interface UserInterface {
    @GetMapping("/{username}")
    List<UserResponse> findByUsername(@PathVariable String username, Pageable pageable);

    @PostMapping
    User save(@RequestBody @Valid UserRequest userRequest);

    @PutMapping("/{id}")
    void update(
            @PathVariable String id,
            @RequestBody @Valid UserRequest request
    );
}
