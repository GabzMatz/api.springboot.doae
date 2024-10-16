package org.twonine.doae.DTO;

import jakarta.validation.Valid;

import java.util.UUID;

public record LoginRequestDTO(@Valid UUID id,String email, String ownership, String password) {
}
