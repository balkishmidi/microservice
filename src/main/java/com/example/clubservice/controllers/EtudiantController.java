package com.example.clubservice.controllers;

import com.example.clubservice.entites.Etudiant;
import com.example.clubservice.entites.Reservation;
import com.example.clubservice.services.IEtudiantService;
import com.example.clubservice.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;
    ReservationService reservationService  ;


    //http://localhost:8081/springProjectTwin2/etudiant/all-etudiants
    @GetMapping("/all-etudiants")
    public List<Etudiant> getEtudiants(){
        List<Etudiant> listEtudiants = etudiantService.AllEtudiants();
        return listEtudiants;
    }

    @GetMapping("/retrieve/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long edId){
        Etudiant etudiant = etudiantService.EtudiantById(edId);
        return etudiant;
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e ){
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/remove/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id")Long edId){
        etudiantService.removeEtudiant(edId);
    }

    @PutMapping("/modify")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e){
        Etudiant etudiant = etudiantService.UpdateEtudiant(e);
        return etudiant;
    }




    @GetMapping("/{idEtudiant}/reservations")
    public ResponseEntity<List<Reservation>> getReservationsForEtudiant(@PathVariable Long idEtudiant) {
        List<Reservation> reservations = etudiantService.getReservationsForEtudiant(idEtudiant);
        return ResponseEntity.ok(reservations);
    }

}
