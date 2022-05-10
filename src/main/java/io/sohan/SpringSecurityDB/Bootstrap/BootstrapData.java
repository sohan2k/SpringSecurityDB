package io.sohan.SpringSecurityDB.Bootstrap;

import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public BootstrapData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1=new User();
        u1.setUserName("sohan");
        u1.setPassword(passwordEncoder.encode("1234"));
        u1.setActive(true);
        u1.setRoles("ROLE_ADMIN");
        userRepository.save(u1);

        User u2=new User();
        u2.setUserName("pocha");
        u2.setPassword(passwordEncoder.encode("1234"));
        u2.setRoles("ROLE_USER");
        u2.setActive(true);
        userRepository.save(u2);
    }
}
