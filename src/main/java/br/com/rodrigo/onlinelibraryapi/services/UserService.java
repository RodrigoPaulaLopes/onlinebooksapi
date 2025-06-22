package br.com.rodrigo.onlinelibraryapi.services;
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

    public ListUserDto findById(String id) {
        return new ListUserDto(userRepository.findById(id).get());
    }

    public ListUserDto save(CreateUserDto user) {
        User newUser = userRepository.save(new User(user));
        return new ListUserDto(newUser);
    }

    public ListUserDto update(String id, CreateUserDto userDetails) {
        User user = this.userRepository.findById(id).get();
        user.update(userDetails);
        
        return new ListUserDto(this.userRepository.save(user));
    }

    public void delete(String id) {
        User user = this.userRepository.findById(id).get();
        userRepository.delete(user);
    }

}

