package org.twonine.doae.model.defaultClass;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DefaultClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private LocalDate createdAt;

    private Boolean isActive = true;
}
