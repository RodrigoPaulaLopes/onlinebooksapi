package br.com.rodrigo.onlinelibraryapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rodrigo.onlinelibraryapi.dtos.CreateUserDto;
import br.com.rodrigo.onlinelibraryapi.dtos.ListUserDto;
import br.com.rodrigo.onlinelibraryapi.entities.User;
import br.com.rodrigo.onlinelibraryapi.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository; 

    public Page<ListUserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(ListUserDto::new);
    }

    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    public User save(CreateUserDto user) {
        return userRepository.save(new User(user));
    }

    public User update(String id, CreateUserDto userDetails) {
        User user = this.userRepository.findById(id).get();

        user.setName(userDetails.name());
        user.setAddress(userDetails.address());
        user.setAuthentication(userDetails.authentication());

        
        return this.userRepository.save(user);
    }

    public void delete(String id) {
        User user = this.userRepository.findById(id).get();
        userRepository.delete(user);
    }

}

