package io.sohan.SpringSecurityDB.Security;

import io.sohan.SpringSecurityDB.Service.JpaUserDetailService;
import io.sohan.SpringSecurityDB.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JpaUserDetailService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password("1234")
//                .roles("ADMIN");
        //auth.userDetailsService(this.userService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                        .antMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
                        .antMatchers("/index").hasRole("USER")
                        .antMatchers(HttpMethod.POST,"/user").hasRole("ADMIN")
                        .antMatchers(HttpMethod.POST,"/role").hasRole("ADMIN")
                        .and().formLogin().and().httpBasic();
//
        http.csrf().disable();
//        http.headers().frameOptions().sameOrigin();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
