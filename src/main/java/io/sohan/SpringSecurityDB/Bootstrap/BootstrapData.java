package io.sohan.SpringSecurityDB.Bootstrap;

import io.sohan.SpringSecurityDB.Domain.Authority;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.AuthorityRepository;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private AuthorityRepository authorityRepository;

    public BootstrapData(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Authority admin=new Authority();
        admin.setRoles("ROLE_ADMIN");
        authorityRepository.save(admin);

        Authority user=new Authority();
        user.setRoles("ROLE_USER");
        authorityRepository.save(user);

        User u1=new User();
        u1.setUserName("sohan");
        u1.setPassword(passwordEncoder.encode("1234"));
        u1.setActive(true);
        //u1.setRoles("ROLE_ADMIN");
        //u1.getAuthorities().add(admin);
        userRepository.save(u1);

        User u2=new User();
        u2.setUserName("pocha");
        u2.setPassword(passwordEncoder.encode("1234"));
        //u2.setRoles("ROLE_USER");
        //u2.getAuthorities().add(user);
        u2.setActive(true);
        userRepository.save(u2);

        admin.getUser().add(u1);
        user.getUser().add(u2);
        authorityRepository.save(admin);
        authorityRepository.save(user);
    }
}
