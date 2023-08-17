package com.arantes.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class AddressEntity {

    private String city;

    private String street;

    private String state;



}
