package com.nttdata.desafio.manager.user.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("contraseña")
    private String password;

    @JsonProperty("telefonos")
    private List<Phone> phones;

    @Data
    public static class Phone {

        @JsonProperty("numero")
        private Long number;

        @JsonProperty("codigoCiudad")
        private Integer cityCode;

        @JsonProperty("codigoPais")
        private Integer countryCode;
    }
}
