package com.nttdata.desafio.manager.user.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("creado")
    private LocalDateTime created;

    @JsonProperty("modificado")
    private LocalDateTime modified;

    @JsonProperty("ultimoLogin")
    private LocalDateTime lastLogin;

    @JsonProperty("token")
    private String token;

    @JsonProperty("activo")
    private Boolean active;
}
