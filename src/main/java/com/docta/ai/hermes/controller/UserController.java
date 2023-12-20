package com.docta.ai.hermes.controller;

import com.docta.ai.hermes.exception.ResourceNotFoundException;
import com.docta.ai.hermes.model.User;
import com.docta.ai.hermes.payload.UserDto;
import com.docta.ai.hermes.repository.UserRepository;
import com.docta.ai.hermes.security.CurrentUser;
import com.docta.ai.hermes.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User GetCurrentUser(@CurrentUser UserPrincipal userPrincipal) throws ResourceNotFoundException {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    @PatchMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public User UpdateUser(@CurrentUser UserDto userDto) throws ResourceNotFoundException {
        var user =  userRepository.findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));

        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }
        return userRepository.save(user);
    }
}
