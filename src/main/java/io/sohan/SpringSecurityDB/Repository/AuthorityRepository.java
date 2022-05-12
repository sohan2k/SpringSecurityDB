package io.sohan.SpringSecurityDB.Repository;

import io.sohan.SpringSecurityDB.Domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
