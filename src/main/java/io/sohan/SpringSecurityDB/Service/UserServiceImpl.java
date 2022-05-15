package io.sohan.SpringSecurityDB.Service;

import io.sohan.SpringSecurityDB.Domain.Role;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.RoleRepository;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList=new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(userList::add);
        return userList;
    }

}
