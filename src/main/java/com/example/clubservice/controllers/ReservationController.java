package com.example.clubservice.controllers;

import com.example.clubservice.entites.Reservation;
import com.example.clubservice.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    IReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        List<Reservation> listReservations = reservationService.AllReservations();
        return listReservations;
    }

    @GetMapping("/retrieve/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long rsId){
        Reservation reservation = reservationService.ReservationById(rsId);
        return reservation;
    }
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation r ){
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }
    @DeleteMapping("/remove/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id")Long rsId){
        reservationService.removeReservation(rsId);
    }
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r){
        Reservation reservation = reservationService.UpdateFoyer(r);
        return reservation;
    }
}
