package com.ronn.reservations.domain.repo;

import com.ronn.reservations.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findClientByDni(String dni);
}