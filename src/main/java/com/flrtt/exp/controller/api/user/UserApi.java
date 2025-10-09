package com.flrtt.exp.controller.api.user;


import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.dto.user.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v1/api/users")
public interface UserApi {
    @GetMapping("/{username}")
    User findByUsername(@PathVariable String username);

    @PostMapping
    User save(@RequestBody @Valid UserRequest userRequest);

    @PutMapping("/{id}")
    void update(
            @PathVariable String id,
            @RequestBody @Valid UserRequest request
    );
}
