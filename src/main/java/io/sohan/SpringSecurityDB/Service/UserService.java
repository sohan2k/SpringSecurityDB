package io.sohan.SpringSecurityDB.Service;


import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Service
public interface UserService{ //implements UserDetailsService {
    User getUser(String username);
    List<User> getAllUser();

    //void addRoleToUser(String username,String rolename);
//    @Autowired
//    UserRepository userRepository;


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user=userRepository.findByUserName(username).orElseThrow(() ->
////        {throw new UsernameNotFoundException("username not found"+username);});
////        return org.springframework.security.core.userdetails.User.builder().username(username).password(user.getPassword())
////                .accountExpired(true).accountLocked(true).credentialsExpired(true).authorities(user.geta);
//        Optional<User>user=userRepository.findByUserName(username);
//        user.orElseThrow(() -> new UsernameNotFoundException("username not found"+username));
//        return user.map(MyUser::new).get();
//    }
}
