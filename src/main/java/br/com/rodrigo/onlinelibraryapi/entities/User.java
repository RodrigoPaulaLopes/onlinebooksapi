package br.com.rodrigo.onlinelibraryapi.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.rodrigo.onlinelibraryapi.dtos.CreateUserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Embedded
    private Name name;

    @Embedded
    private Authentication authentication;

    @Embedded
    private Address address;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public User(CreateUserDto user) {
        this.update(user);
    }

    public void update(CreateUserDto user) {
        this.setName(new Name(user.first_name(), user.last_name()));
        this.setAuthentication(new Authentication(user.email(), user.password()));
        this.setAddress(new Address(user.street(), user.number(), user.complement(), user.neighborhood(), user.city(),
                user.state(), user.zipCode()));
    }

}
