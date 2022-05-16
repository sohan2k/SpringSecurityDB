package io.sohan.SpringSecurityDB.Controller;

import io.sohan.SpringSecurityDB.Authentication.AuthenticationRequest;
import io.sohan.SpringSecurityDB.Authentication.AuthenticationResponse;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Jwt.JwtUtill;
import io.sohan.SpringSecurityDB.Service.JpaUserDetailService;
import io.sohan.SpringSecurityDB.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexContrller {
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtUtill jwtUtill;

    private JpaUserDetailService jpaUserDetailService;

    public IndexContrller(UserService userService, AuthenticationManager authenticationManager, JwtUtill jwtUtill, JpaUserDetailService jpaUserDetailService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtill = jwtUtill;
        this.jpaUserDetailService = jpaUserDetailService;
    }

    @GetMapping("/index")
    public ResponseEntity<String> getIndex(){
        return ResponseEntity.ok().body("</h1>Welcome to Spring test</h1>");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }

//    @PostMapping("/role")
//    public void addRole(@RequestBody Role role){
//        userService.addRole(role);
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword())
            );
        }catch(BadCredentialsException e){
            throw new Exception("Incorrrect username or password",e);
        }
        final UserDetails userDetails=jpaUserDetailService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt= jwtUtill.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
