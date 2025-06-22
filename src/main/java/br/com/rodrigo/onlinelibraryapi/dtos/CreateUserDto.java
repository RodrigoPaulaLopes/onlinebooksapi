package br.com.rodrigo.onlinelibraryapi.dtos;
import br.com.rodrigo.onlinelibraryapi.entities.Name;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(
    @NotNull(message = "The first name is required")
    String first_name, 
    @NotNull(message = "The last name is required")
    String last_name, 
    @NotNull(message = "The email is required")
    @Email(message = "The field email must be a valid email.")
    String email,
    @NotNull(message = "The password is required")
    String password, 
    String street,
    String number,
    String complement,
    String neighborhood,
    String city,
    String state,
    String zipCode
    ) {
}
