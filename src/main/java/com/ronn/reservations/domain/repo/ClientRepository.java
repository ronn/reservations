package com.ronn.reservations.domain.repo;

import com.ronn.reservations.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Reservation, String> {
}