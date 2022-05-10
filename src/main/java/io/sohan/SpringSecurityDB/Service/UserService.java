package io.sohan.SpringSecurityDB.Service;

import io.sohan.SpringSecurityDB.Domain.MyUser;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=userRepository.findByUserName(username).orElseThrow(() ->
//        {throw new UsernameNotFoundException("username not found"+username);});
//        return org.springframework.security.core.userdetails.User.builder().username(username).password(user.getPassword())
//                .accountExpired(true).accountLocked(true).credentialsExpired(true).authorities(user.geta);
        Optional<User>user=userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("username not found"+username));
        return user.map(MyUser::new).get();
    }
}
