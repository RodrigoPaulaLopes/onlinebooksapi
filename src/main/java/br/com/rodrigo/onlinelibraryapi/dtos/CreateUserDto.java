package br.com.rodrigo.onlinelibraryapi.dtos;
import br.com.rodrigo.onlinelibraryapi.entities.Name;
import br.com.rodrigo.onlinelibraryapi.entities.Authentication;
import br.com.rodrigo.onlinelibraryapi.entities.Address;


public record CreateUserDto(Name name, Authentication authentication, Address address) {
}
