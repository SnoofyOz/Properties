package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.dto.user.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
public interface UserInterface {
    @GetMapping("/{id}")
    User findById(@PathVariable String id);

    @PostMapping
    User save(@RequestBody @Valid UserRequest userRequest);

    @PutMapping("/{id}")
    void update(
            @PathVariable String id,
            @RequestBody @Valid UserRequest request
    );
}
