package com.flrtt.exp.controller.api.authentication;

import com.flrtt.exp.controller.api.authentication.models.AuthRequest;
import com.flrtt.exp.controller.api.authentication.models.AuthResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthInterface {
    @PostMapping("/login")
    AuthResponse login(@RequestBody AuthRequest authRequest);
}
