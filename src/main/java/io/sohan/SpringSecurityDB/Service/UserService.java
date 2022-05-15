package io.sohan.SpringSecurityDB.Service;


import io.sohan.SpringSecurityDB.Domain.Role;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService {
    User getUser(String username);
    List<User> getAllUser();

    void addUser(User user);
    void addRoleToUser(String username,String rolename);

    void addRole(Role role);

}
