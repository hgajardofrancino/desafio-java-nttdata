package com.nttdata.desafio.manager.user.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "telefonos")
public class PhoneEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long number;
    private Integer cityCode;
    private Integer countryCode;
}
