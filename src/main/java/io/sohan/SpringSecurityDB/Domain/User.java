package io.sohan.SpringSecurityDB.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    //private boolean active;

    @Singular
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns  = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")})
    private Set<Role> roles;


    @Builder.Default
    private boolean accountNonExpired=true;

    @Builder.Default
    private boolean accountNonLocked=true;

    @Builder.Default
    private boolean credentialsNonExpired=true;

    @Builder.Default
    private  boolean enabled=true;
}
