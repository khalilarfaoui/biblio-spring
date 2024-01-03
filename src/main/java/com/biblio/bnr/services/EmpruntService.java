package com.biblio.bnr.services;

import com.biblio.bnr.entity.Emprunt;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.repositories.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService implements IEmpruntService{
    @Autowired
    private EmpruntRepository empruntRepository;

    @Override
    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    @Override
    public Emprunt getEmpruntById(Long id) {
        Optional<Emprunt> optionalEmprunt = empruntRepository.findById(id);
        return optionalEmprunt.orElse(null);
    }

    @Override
    public Emprunt createEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    @Override
    public Emprunt updateEmprunt(Long id, Emprunt updatedEmprunt) {
        if (empruntRepository.existsById(id)) {
            updatedEmprunt.setId(id);
            return empruntRepository.save(updatedEmprunt);
        }
        return null;
    }

    @Override
    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }

    @Override
    public List<Emprunt> getEmpruntsByUsername(String username) {
        return empruntRepository.findByUserUsername(username);
    }

    public List<Emprunt> getEmpruntsByLivre(Livre livre) {
        return empruntRepository.findByLivre(livre);
    }

    public Optional<Emprunt> getEmpruntByCode(String code) {
        return empruntRepository.findByCode(code);
    }


}
