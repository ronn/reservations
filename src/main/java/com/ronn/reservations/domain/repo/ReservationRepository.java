package com.ronn.reservations.domain.repo;

import com.ronn.reservations.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}