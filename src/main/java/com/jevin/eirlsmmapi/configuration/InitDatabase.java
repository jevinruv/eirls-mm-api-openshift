package com.jevin.eirlsmmapi.configuration;

import com.jevin.eirlsmmapi.form.UserSignUp;
import com.jevin.eirlsmmapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitDatabase implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) {
        init();
    }

    public void init() {

        Set<String> adminRole = new HashSet<>();
        adminRole.add("admin");

        Set<String> mmRole = new HashSet<>();
        mmRole.add("mm");

        Set<String> mcRole = new HashSet<>();
        mcRole.add("mc");

        Set<String> sRole = new HashSet<>();
        sRole.add("s");

        UserSignUp admin = new UserSignUp("Admin", "admin", "admin@gmail.com", adminRole, "qwerty");
        UserSignUp mm = new UserSignUp("Tom", "tom", "tom@gmail.com", mmRole, "qwerty");
        UserSignUp mc = new UserSignUp("John", "john", "john@gmail.com", mcRole, "qwerty");
        UserSignUp s = new UserSignUp("Supplier", "supplier", "supplier@gmail.com", sRole, "qwerty");

        admin.setRole(adminRole);
        mm.setRole(mmRole);
        mc.setRole(mcRole);
        s.setRole(sRole);

        userService.createUser(admin);
        userService.createUser(mm);
        userService.createUser(mc);
        userService.createUser(s);
    }


}
