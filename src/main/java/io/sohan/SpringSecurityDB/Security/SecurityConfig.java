package io.sohan.SpringSecurityDB.Security;

import io.sohan.SpringSecurityDB.Service.JpaUserDetailService;
import io.sohan.SpringSecurityDB.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    //@Autowired
    //UserDetailsService userDetailsService;
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
                        .antMatchers("/user").hasRole("ADMIN")
                        .antMatchers("/index").hasRole("USER")
                        .and().formLogin();

//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//
//        http
//                .authorizeRequests(authorize->{
//                    authorize
//                            .antMatchers("/user").hasRole("ADMIN")
//                            .antMatchers("/index").hasRole("USER");
//                })
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
