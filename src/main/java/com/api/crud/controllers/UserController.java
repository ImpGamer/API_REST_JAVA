package com.api.crud.controllers;

import com.api.crud.models.User;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/show")
    public ArrayList<User> getUsers() {
        return userService.traerUsuarios();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User newUser;
        try {
            newUser = userService.agregarUsuario(user);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    //Clase "ResponseEntity" para mandar cualquier tipo de objeto, con un estado HTTP
    public ResponseEntity<?> editUser(@PathVariable Long id,@RequestBody User user) {
        User newUser;
        try {
            newUser = userService.editarUsuario(user,id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.eliminarUsuario(id);
    }
}