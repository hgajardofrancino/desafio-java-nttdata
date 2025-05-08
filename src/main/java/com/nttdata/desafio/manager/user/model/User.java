package com.nttdata.desafio.manager.user.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
}
