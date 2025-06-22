package br.com.rodrigo.onlinelibraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.rodrigo.onlinelibraryapi.services.UserService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rodrigo.onlinelibraryapi.dtos.CreateUserDto;
import br.com.rodrigo.onlinelibraryapi.dtos.ListUserDto;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ListUserDto> create(@Valid @RequestBody CreateUserDto user, UriComponentsBuilder builder) {
        ListUserDto createdUser = userService.save(user);

        var uri = builder.path("/api/v1/user/{id}").buildAndExpand(createdUser.id()).toUri();
        return ResponseEntity.created(uri).body(createdUser);
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
    public ResponseEntity<ListUserDto> update(@PathVariable String id, @Valid @RequestBody CreateUserDto user) {
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
