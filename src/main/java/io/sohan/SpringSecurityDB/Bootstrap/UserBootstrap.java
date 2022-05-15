package io.sohan.SpringSecurityDB.Bootstrap;

import io.sohan.SpringSecurityDB.Domain.Role;
import io.sohan.SpringSecurityDB.Domain.User;
import io.sohan.SpringSecurityDB.Repository.RoleRepository;
import io.sohan.SpringSecurityDB.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class UserBootstrap implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        Role admin=roleRepository.save(Role.builder().name("ROLE_ADMIN").build());
        Role user=roleRepository.save(Role.builder().name("ROLE_USER").build());

        User u1=userRepository.save(User.builder()
                .userName("sohan")
                .password(passwordEncoder.encode("1234"))
                .role(admin)
                .build());
        User u2=userRepository.save(User.builder()
                .userName("pocha")
                .password(passwordEncoder.encode("1234"))
                .role(user)
                .build());
    }
}
