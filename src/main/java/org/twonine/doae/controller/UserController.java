package org.twonine.doae.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.twonine.doae.DTO.*;
import org.twonine.doae.model.user.Role;
import org.twonine.doae.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> registerUser(@RequestBody RegisterRequestDTO body){
        return userService.createUser(body);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginRequestDTO body){
        return userService.loginUser(body);
    }

    @GetMapping("/NGO")
    public ResponseEntity<List<NgoAndCompanyResponseDTO>> searchNGO(){
        return userService.searchService(Role.NGO);
    }
    @GetMapping("/COMPANY")
    public ResponseEntity<List<NgoAndCompanyResponseDTO>> searchCOMPANY(){
        return userService.searchService(Role.COMPANY);
    }
    @DeleteMapping("/delete-{id}")
    public void deleteUser(@PathVariable DeleteRequestDTO body){
        userService.deleteUser(body);
    }

}
