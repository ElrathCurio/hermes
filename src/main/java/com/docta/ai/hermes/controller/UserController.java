package com.docta.ai.hermes.controller;

import com.docta.ai.hermes.exception.ResourceNotFoundException;
import com.docta.ai.hermes.model.User;
import com.docta.ai.hermes.repository.UserRepository;
import com.docta.ai.hermes.security.CurrentUser;
import com.docta.ai.hermes.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) throws ResourceNotFoundException {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }
}
