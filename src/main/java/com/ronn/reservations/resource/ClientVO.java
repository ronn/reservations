package com.ronn.reservations.resource;

import lombok.Data;

@Data
public class ClientVO {

    private String id;
    private String dni;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
}