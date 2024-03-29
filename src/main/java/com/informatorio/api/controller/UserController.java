package com.informatorio.api.controller;


import com.informatorio.api.model.User;
import com.informatorio.api.repository.UserRepository;
import com.informatorio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/resistencia")
    public ResponseEntity<?> getCity(){
        return new ResponseEntity<>(userService.getCity(), HttpStatus.OK);
    }
    @GetMapping("/alta/{fecha}")
    public ResponseEntity<?> getUsDate(@PathVariable String fecha){
        return new ResponseEntity<>(userService.getUsDate(fecha), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> editUser(@PathVariable Long userId, @RequestBody User user){

        return new ResponseEntity<>(userService.editUser(userId, user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
