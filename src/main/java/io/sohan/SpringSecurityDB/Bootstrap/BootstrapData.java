//package io.sohan.SpringSecurityDB.Bootstrap;
//
//import io.sohan.SpringSecurityDB.Domain.Role;
//import io.sohan.SpringSecurityDB.Domain.User;
//import io.sohan.SpringSecurityDB.Repository.RoleRepository;
//import io.sohan.SpringSecurityDB.Repository.UserRepository;
//import io.sohan.SpringSecurityDB.Service.UserService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BootstrapData implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    //private final PasswordEncoder passwordEncoder;
//    private UserService userService;
//
//
//    public BootstrapData(UserRepository userRepository, RoleRepository roleRepository,UserService userService) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.userService=userService;
//    }
//
//
////    public BootstrapData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
////        this.userRepository = userRepository;
////        this.passwordEncoder = passwordEncoder;
////    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Role admin=new Role();
//        admin.setName("ROLE_ADMIN");
//        roleRepository.save(admin);
//
//        Role user=new Role();
//        user.setName("ROLE_USER");
//        roleRepository.save(user);
//
//        User u1=new User();
//        u1.setUserName("sohan");
//        //u1.setPassword(passwordEncoder.encode("1234"));
//        u1.setPassword("1234");
//        u1.setActive(true);
//        //u1.setRoles("ROLE_ADMIN");
//        u1.getRoles().add(admin);
//        userRepository.save(u1);
//
//        User u2=new User();
//        u2.setUserName("pocha");
//        u2.setPassword("1234");
//        //u2.setPassword(passwordEncoder.encode("1234"));
//        //u2.setRoles("ROLE_USER");
//        //u2.getRoles().add(user);
//        u2.setActive(true);
//        userRepository.save(u2);
//
////        admin.getUsers().add(u1);
////        roleRepository.save(admin);
////        user.getUsers().add(u2);
////        roleRepository.save(user);
//        //userService.addRoleToUser("sohan","ROLE_ADMIN");
//
//    }
//}
