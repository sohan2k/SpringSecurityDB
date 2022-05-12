package io.sohan.SpringSecurityDB.Domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUser implements UserDetails {

    private final String userName;
    private final String password;
    private boolean active;
    private List<SimpleGrantedAuthority> authorities;// =new ArrayList<>();

    public MyUser(User user) {
        this.userName = user.getUserName();
        this.password=user.getPassword();
        this.active=user.isActive();
//        this.authorities= Arrays.stream(user.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        user.getAuthorities().forEach(authority -> {
            authorities.add(new SimpleGrantedAuthority(authority.getRoles()));
        });
//        this.authorities=Arrays.stream(user.getAuthorities().forEach(authority -> {
//            authorities.add(new SimpleGrantedAuthority(authority.getRoles()))
//        });)
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       // return //(Collection<? extends GrantedAuthority>) authorities;
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
