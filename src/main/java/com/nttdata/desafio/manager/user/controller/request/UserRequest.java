package com.nttdata.desafio.manager.user.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;

    @Data
    public static class Phone {
        private Long number;
        private Integer cityCode;
        private Integer countryCode;
    }
}
