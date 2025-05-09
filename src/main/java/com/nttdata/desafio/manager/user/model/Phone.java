package com.nttdata.desafio.manager.user.model;

import lombok.Data;

@Data
public class Phone {
    private Long number;
    private Integer cityCode;
    private Integer countryCode;
}
