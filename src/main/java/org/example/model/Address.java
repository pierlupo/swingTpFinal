package org.example.model;

import lombok.Data;

@Data
public class Address {

    private int id;

    private String street;

    private String town;

    public Address(String street, String town) {
        this.street = street;
        this.town = town;
    }

    public Address(int id, String street, String town) {
        this.id = id;
        this.street = street;
        this.town = town;
    }

    public Address() {
    }
}
