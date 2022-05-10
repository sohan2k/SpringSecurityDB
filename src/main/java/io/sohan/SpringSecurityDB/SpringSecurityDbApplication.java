package io.sohan.SpringSecurityDB;

import io.sohan.SpringSecurityDB.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApplication.class, args);
	}

}
