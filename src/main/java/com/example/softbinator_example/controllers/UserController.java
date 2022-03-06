package com.example.softbinator_example.controllers;

import com.example.softbinator_example.models.User;
import com.example.softbinator_example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Un controller defineste niste endpoint-uri care sunt puncte de acces in aplicatia noastra
// REMEMBER - NO BUSINESS LOGIC IN CONTROLLER, asta e treaba serviciului
@RestController // - notifica Spring ca este un controller REST
@RequestMapping("/user") // - "Asculta" pe http://localhost:8081/user
public class UserController {
    private final UserService userService;

    // Injectam userService pentru business logic
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Am schimbat tipul de raspuns cu ResponseEntity<UserInfoDto>(userInfoDto, HttpStatus.OK)
    // Tot ce face obiectul acesta este sa mappeze obiectul pe care il dam pe un raspuns cu un status
    // <?> inseamna orice, so basically ResponseEntity<orice>, in cazul nostru ResponseEntity<UserInfoDto>
    // "Asculta" pe request-uri de tip GET pe http://localhost:8080/user/numar
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    // "Asculta" pe request-uri de tip POST pe http://localhost:8080/user
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

}
