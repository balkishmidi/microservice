package com.example.clubservice.services;


import com.example.clubservice.entites.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> AllReservations();
    public Reservation ReservationById(Long id);
    public Reservation addReservation(Reservation b);
    public void removeReservation(long id);
    public Reservation UpdateFoyer(Reservation b);
}
