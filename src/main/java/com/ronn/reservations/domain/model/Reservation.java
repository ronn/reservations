package com.ronn.reservations.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private LocalDate startDate;
    private LocalDate finishDate;
    private Integer peopleQuantity;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
