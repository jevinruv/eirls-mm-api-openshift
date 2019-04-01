package com.jevin.eirlsmmapi.service;

import com.jevin.eirlsmmapi.form.UserSignUp;
import com.jevin.eirlsmmapi.model.Role;
import com.jevin.eirlsmmapi.model.RoleName;
import com.jevin.eirlsmmapi.model.User;
import com.jevin.eirlsmmapi.repository.RoleRepo;
import com.jevin.eirlsmmapi.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    public void createUser(UserSignUp userSignUp){


        User user = new User(userSignUp.getName(), userSignUp.getUsername(), userSignUp.getEmail(), encoder.encode(userSignUp.getPassword()));
        Set<String> strRoles = userSignUp.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {

            switch (role){
                case "admin":
                    Role adminRole = roleRepo.findByName(RoleName.ROLE_ADMIN).orElseThrow(()-> new RuntimeException("User role not found"));
                    roles.add(adminRole);
                    break;
                case "mm":
                    Role mmRole = roleRepo.findByName(RoleName.ROLE_MM).orElseThrow(()-> new RuntimeException("User role not found"));
                    roles.add(mmRole);
                    break;
                case "mc":
                    Role mcRole = roleRepo.findByName(RoleName.ROLE_MC).orElseThrow(()-> new RuntimeException("User role not found"));
                    roles.add(mcRole);
                    break;
                case "s":
                    Role sRole = roleRepo.findByName(RoleName.ROLE_S).orElseThrow(()-> new RuntimeException("User role not found"));
                    roles.add(sRole);
                    break;
            }
        });

        user.setRoles(roles);
        userRepo.save(user);

    }
}
