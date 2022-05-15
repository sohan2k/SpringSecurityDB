package io.sohan.SpringSecurityDB.Repository;

import io.sohan.SpringSecurityDB.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    //Optional<User> findByUsername(String username);
    User findByUserName(String username);
}
