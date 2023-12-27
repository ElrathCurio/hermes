package com.docta.ai.hermes.controller;

import com.docta.ai.hermes.exception.BadRequestException;
import com.docta.ai.hermes.model.AuthProviderEnum;
import com.docta.ai.hermes.model.User;
import com.docta.ai.hermes.payload.ApiResponse;
import com.docta.ai.hermes.payload.AuthResponse;
import com.docta.ai.hermes.payload.LoginRequest;
import com.docta.ai.hermes.payload.SignUpRequest;
import com.docta.ai.hermes.repository.UserRepository;
import com.docta.ai.hermes.security.AuthenticationService;
import com.docta.ai.hermes.security.TokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name  = "登录功能")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary ="用户名密码登录")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody @Parameter(name = "姓名", required = true, example = "村雨遥") LoginRequest loginRequest) {
        User authenticatedUser = authenticationService.authenticate(loginRequest);

        String jwtToken = tokenProvider.createToken(authenticatedUser);

        AuthResponse loginResponse = new AuthResponse(jwtToken, tokenProvider.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @Operation(summary ="用户名密码注册")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByName(signUpRequest.getName())) {
            throw new BadRequestException("User name already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setProvider(AuthProviderEnum.local);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }

}
