package br.com.rodrigo.onlinelibraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.rodrigo.onlinelibraryapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.rodrigo.onlinelibraryapi.dtos.CreateUserDto;
import br.com.rodrigo.onlinelibraryapi.dtos.ListUserDto;
import br.com.rodrigo.onlinelibraryapi.entities.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ListUserDto> create(@RequestBody CreateUserDto user) {
        ListUserDto createdUser = userService.save(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<Page<ListUserDto>> index(Pageable page) {
        return ResponseEntity.ok(userService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListUserDto> show(@PathVariable String id) {
        ListUserDto user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListUserDto> update(@PathVariable String id, @RequestBody CreateUserDto user) {
        ListUserDto updatedUser = userService.update(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
  
    }


}
