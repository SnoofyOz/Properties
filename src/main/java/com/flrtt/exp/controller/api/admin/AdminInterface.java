package com.flrtt.exp.controller.api.admin;

import com.flrtt.exp.controller.api.portal.models.PortalResponse;
import com.flrtt.exp.controller.api.property.models.PropertyResponse;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.dto.user.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.flrtt.exp.constants.PathConstants.*;

@RequestMapping(API_ADMIN)
public interface AdminInterface {

    @GetMapping(ALL_USER)
    List<UserResponse> findAllUser(
            @RequestParam(value = "code" , required = false) String code
    );

    @GetMapping(USER_ID)
    User findById(@PathVariable String id);

    @PutMapping(USER_ID)
    void update(
            @PathVariable String id,
            @RequestBody @Valid UserRequest request
    );
    @DeleteMapping(USER_ID)
    void delete(@PathVariable String id);

    @GetMapping(ALL_PROPERTY)
    List<PropertyResponse> findAllProperties(
            @RequestParam(value = "code" , required = false) String code
    );

    @GetMapping(ALL_PORTAL)
    List<PortalResponse> findAllPortal(
            @RequestParam(value = "code" , required = false) String code
    );
}
