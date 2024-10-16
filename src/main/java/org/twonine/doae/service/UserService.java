package org.twonine.doae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.twonine.doae.DTO.*;
import org.twonine.doae.model.user.Role;
import org.twonine.doae.model.user.User;
import org.twonine.doae.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity<RegisterResponseDTO> createUser(RegisterRequestDTO body){
        Optional<User> user = this.repository.findByEmail(body.email());
        if(user.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        User newUser = new User();
        newUser.setPassword(body.password());
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        newUser.setRole(body.role());
        newUser.setAddress(body.address());
        newUser.setOwnership(body.ownership());
        newUser.setPhone(body.phone());
        newUser.setDescription(body.description());
        newUser.setImageUrl(body.imageUrl());
        newUser.setCategory(body.category());
        repository.save(newUser);

        return ResponseEntity.ok(new RegisterResponseDTO(newUser.getId(),newUser.getCategory(),newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole(), newUser.getPhone(), newUser.getDescription(), newUser.getImageUrl()));
    }

    public ResponseEntity<List<NgoAndCompanyResponseDTO>> searchService(Role role){
        List<User> users =this.repository.findByRole(role);

        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<NgoAndCompanyResponseDTO> responseList = users.stream()
                .map(user -> new NgoAndCompanyResponseDTO(
                        user.getId(),
                        user.getCategory(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getPhone(),
                        user.getDescription(),
                        user.getImageUrl(),
                        new AddressDTO(user.getAddress().getPostalCode(),user.getAddress().getStreet(),
                                user.getAddress().getNumber(),user.getAddress().getCity(),user.getAddress().getCountry(),user.getAddress().getState(), user.getAddress().getComplement()
                        )
                ))
                .toList();

        return ResponseEntity.ok(responseList);

    }

    public ResponseEntity<LoginResponseDTO> loginUser(LoginRequestDTO body) {
        Optional<User> user = this.repository.findFirstByEmailOrOwnership(body.email(), body.ownership());
        if(user.isPresent()){
            if(user.get().getPassword().equals(body.password())){
                return ResponseEntity.ok(new LoginResponseDTO(user.get().getId(), user.get().getEmail(), user.get().getPassword()));
            }
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Void> deleteUser(DeleteRequestDTO body) {
        Optional<User> user = repository.findById(body.id());
        if(user.isPresent()){
            repository.delete(user.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
