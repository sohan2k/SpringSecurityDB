package io.sohan.SpringSecurityDB.Service;

import io.sohan.SpringSecurityDB.Domain.Role;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.RoleRepository;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
//@RequiredArgsConstructor
@Configuration
public class JpaUserDetailService implements UserDetailsService {
    UserRepository userRepository;

    public JpaUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("user name not found"+username);
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),user.isEnabled(),user.isAccountNonExpired(),user.isCredentialsNonExpired()
        ,user.isAccountNonLocked(),authorities);
    }
}

