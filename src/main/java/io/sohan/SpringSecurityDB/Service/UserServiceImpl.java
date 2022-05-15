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
//@Transactional
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

//    @Override
//    public void addRoleToUser(String username, String rolename) {
//        User user=userRepository.findByUserName(username);
//        Role role=roleRepository.findByName(rolename);
//        user.getRoles().add(role);
//    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user=userRepository.findByUserName(username);
//        if(user==null){
//            throw new UsernameNotFoundException("user name not found"+username);
//        }
//        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        });
//        return new org.springframework.security.core.userdetails.User(user.getUserName(),
//                user.getPassword(),authorities);
//        //return new org.springframework.security.core.userdetails.User()
//
//    }
}
