package io.sohan.SpringSecurityDB.Repository;

import io.sohan.SpringSecurityDB.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
