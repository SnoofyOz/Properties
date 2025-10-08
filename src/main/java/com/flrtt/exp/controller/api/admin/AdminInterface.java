package com.flrtt.exp.controller.api.admin;

import com.flrtt.exp.controller.api.portal.models.PortalResponse;
import com.flrtt.exp.controller.api.property.models.PropertyResponse;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.dto.user.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/v1/api/admin")
public interface AdminInterface {

    @GetMapping("/users")
    List<UserResponse> findAllUser(
            @RequestParam(value = "code" , required = false) String code
    );

    @GetMapping("/users/{id}")
    User findById(@PathVariable String id);

    @PutMapping("/users/{id}")
    void update(
            @PathVariable String id,
            @RequestBody @Valid UserRequest request
    );
    @DeleteMapping("/users/{id}")
    void delete(@PathVariable String id);

    @GetMapping("/properties")
    List<PropertyResponse> findAllProperties(
            @RequestParam(value = "code" , required = false) String code
    );

    @GetMapping("/portals")
    List<PortalResponse> findAllPortal(
            @RequestParam(value = "code" , required = false) String code
    );
    @GetMapping("/users/test")
    List<UserResponse> findAllByOrderByUsernameAsc(
        @RequestParam(value = "code" , required = false) String code
    );
}
