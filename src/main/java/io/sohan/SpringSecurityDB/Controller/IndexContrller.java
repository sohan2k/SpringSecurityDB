package io.sohan.SpringSecurityDB.Controller;

import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexContrller {
    UserService userService;

    public IndexContrller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String getIndex(){
        return "</h1>Welcome to Spring test</h1>";
    }

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
