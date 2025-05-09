package com.nttdata.desafio.manager.user.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private String id;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade=CascadeType.ALL)
    private List<PhoneEntity> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean active;
}

