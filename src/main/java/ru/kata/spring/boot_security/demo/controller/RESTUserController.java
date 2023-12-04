package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class RESTUserController {
    private final UserService userService;

    @Autowired
    public RESTUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getCurrent(Principal principal) {
        return new ResponseEntity<>(userService.loadUserByUsername(principal.getName()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
