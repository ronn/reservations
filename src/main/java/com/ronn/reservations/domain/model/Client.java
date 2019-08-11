package com.ronn.reservations.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String dni;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;
}
