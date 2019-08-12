package com.ronn.reservations.domain.service;

import com.ronn.reservations.domain.model.Reservation;
import com.ronn.reservations.domain.repo.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationtService {

    private final ReservationRepository reservationRepo;

    public ReservationtService(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public Reservation save(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationRepo.delete(reservation);
    }
}