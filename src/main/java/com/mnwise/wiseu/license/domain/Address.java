package com.mnwise.wiseu.license.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String zipcode;
    private String street;
    private String city;
}
