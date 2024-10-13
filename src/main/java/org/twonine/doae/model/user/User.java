package org.twonine.doae.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.twonine.doae.model.defaultClass.DefaultClass;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends DefaultClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String ownership;

    private String name;

    private String password;

    private String email;

    private String phone;

    private String description;

    private String imageUrl;

    private Boolean isAnonymous = false;

    private Address address;
}
