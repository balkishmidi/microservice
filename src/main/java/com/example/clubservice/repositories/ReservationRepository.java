package com.example.clubservice.repositories;

import com.example.clubservice.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
