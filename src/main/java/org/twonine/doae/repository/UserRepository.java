package org.twonine.doae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.twonine.doae.model.user.Role;
import org.twonine.doae.model.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    Optional<User> findByEmail(String username);
    Optional<User> findFirstByEmailOrOwnership(String email, String ownership);
    List<User> findByRole(Role role);

}