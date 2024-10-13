package org.twonine.doae.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String postalCode;

    private String street;

    private Integer number;

    private String city;

    private String country;

    private String state;

    private String complement;

    private User user;
}
