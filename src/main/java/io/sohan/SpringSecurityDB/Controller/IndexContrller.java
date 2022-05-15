package io.sohan.SpringSecurityDB.Controller;

import io.sohan.SpringSecurityDB.Domain.Role;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
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

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("/role")
    public void addRole(@RequestBody Role role){
        userService.addRole(role);
    }
}
