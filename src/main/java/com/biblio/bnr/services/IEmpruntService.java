package com.biblio.bnr.services;

import com.biblio.bnr.entity.Emprunt;
import com.biblio.bnr.entity.Livre;

import java.util.List;
import java.util.Optional;

public interface IEmpruntService {

    List<Emprunt> getAllEmprunts();

    Emprunt getEmpruntById(Long id);

    Emprunt createEmprunt(Emprunt emprunt);

    Emprunt updateEmprunt(Long id, Emprunt emprunt);

    void deleteEmprunt(Long id);

    List<Emprunt> getEmpruntsByUsername(String username);

    List<Emprunt> getEmpruntsByLivre(Livre livre);

    Optional<Emprunt> getEmpruntByCode(String code);

}