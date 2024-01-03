package com.biblio.bnr.services;


import com.biblio.bnr.entity.Reservation;

import java.util.List;

public interface IReservationService {

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);

    Reservation createReservation(Reservation emprunt);

    Reservation updateReservation(Long id, Reservation emprunt);

    void deleteReservation(Long id);
}