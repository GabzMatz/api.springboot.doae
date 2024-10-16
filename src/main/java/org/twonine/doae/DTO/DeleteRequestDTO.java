package org.twonine.doae.DTO;

import jakarta.validation.Valid;
import java.util.UUID;

public record DeleteRequestDTO(@Valid UUID id, String email) {
}
