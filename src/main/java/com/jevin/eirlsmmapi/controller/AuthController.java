package com.jevin.eirlsmmapi.controller;

import com.jevin.eirlsmmapi.form.UserSignUp;
import com.jevin.eirlsmmapi.model.User;
import com.jevin.eirlsmmapi.repository.UserRepo;
import com.jevin.eirlsmmapi.security.JwtProvider;

import com.jevin.eirlsmmapi.security.JwtResponse;
import com.jevin.eirlsmmapi.security.ResponseMessage;
import com.jevin.eirlsmmapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserSignUp userSignUp){

        if(userRepo.existsByUsername(userSignUp.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("Username already exists"), HttpStatus.BAD_REQUEST);
        }

        if (userRepo.existsByEmail(userSignUp.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("Email already exists"), HttpStatus.BAD_REQUEST);
        }

        // If user does not exist create account
        userService.createUser(userSignUp);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully"), HttpStatus.OK);
    }
}
