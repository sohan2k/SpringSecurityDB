package io.sohan.SpringSecurityDB.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexContrller {

    @GetMapping("/user")
    private String getUser(){
        return "</h1>Welcome to Spring test</h1>";
    }
}
