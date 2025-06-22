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
public class Name {
    

    @Column(nullable = true)
    private String first_name;

     @Column(nullable = true)
    private String last_name;
}
