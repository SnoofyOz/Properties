package com.flrtt.exp.controller.api.authentication;

import com.flrtt.exp.controller.api.authentication.models.AuthRequest;
import com.flrtt.exp.controller.api.authentication.models.AuthResponse;
import com.flrtt.exp.service.authentication.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController implements  AuthInterface {
    AuthService authService;

    @Override
    public AuthResponse login(AuthRequest Request) {
        return authService.login(Request);
    }
}
