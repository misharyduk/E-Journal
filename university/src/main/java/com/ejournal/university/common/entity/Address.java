package com.ejournal.university.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    public Long id;
    @Column(name = "country")
    public String country;
    @Column(name = "city")
    public String city;
    @Column(name = "street")
    public String street;
    @Column(name = "number")
    public String number;
    @Column(name = "zipCode")
    public String zipCode;

}
