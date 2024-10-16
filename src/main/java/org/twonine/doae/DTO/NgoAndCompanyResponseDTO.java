package org.twonine.doae.DTO;

import jakarta.validation.Valid;
import org.twonine.doae.model.user.Category;
import org.twonine.doae.model.user.Role;

import java.util.UUID;

public record NgoAndCompanyResponseDTO(@Valid UUID id, Category category, String name, String email, Role role, String phone,
                                       String description, String imageUrl, AddressDTO addressDTO) {
}

