package org.twonine.doae.DTO;

import jakarta.validation.Valid;
import org.twonine.doae.model.user.Address;
import org.twonine.doae.model.user.Category;
import org.twonine.doae.model.user.Role;

import java.util.UUID;


public record RegisterRequestDTO(@Valid UUID id, String name, String email, String ownership, String password,
                                 Role role, String phone, String description, String imageUrl,
                                 Boolean isAnonymous, Address address, Category category){}
