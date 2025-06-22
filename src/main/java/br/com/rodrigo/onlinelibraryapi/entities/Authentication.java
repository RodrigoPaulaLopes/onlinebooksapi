package br.com.rodrigo.onlinelibraryapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
