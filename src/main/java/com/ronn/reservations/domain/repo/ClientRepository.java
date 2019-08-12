package com.ronn.reservations.domain.repo;

import com.ronn.reservations.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

    Client findClientByDni(String dni);
}