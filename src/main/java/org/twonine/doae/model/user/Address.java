package org.twonine.doae.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String street;


    private Integer number;

    private String city;

    private String country;

    private String state;

    private String complement;

    @OneToOne(mappedBy = "address")
    private User user;
}
