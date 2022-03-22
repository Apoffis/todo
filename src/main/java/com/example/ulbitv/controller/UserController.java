package com.example.ulbitv.controller;

import com.example.ulbitv.service.UserService;
import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.exceptions.UserAlreadyExists;
import com.example.ulbitv.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity getUsers() {
        try {

            return ResponseEntity.ok(userService.getUsers());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Something Wrong!");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Something Wrong!");
        }
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User created successful");
        } catch (UserAlreadyExists ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Something Wrong!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Something Wrong!");
        }
    }

}
