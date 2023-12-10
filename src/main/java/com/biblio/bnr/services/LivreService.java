package com.biblio.bnr.services;

import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService implements ILivreService {

    @Autowired
    private LivreRepository livreRepository;
    @Override
    public List<Livre> retrieveLivres() {
        return livreRepository.findAll();
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return null;
    }

    @Override
    public Livre addLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Optional<Livre> retrieveLivreById(long idLivre) {
        return livreRepository.findById(idLivre);
    }

    @Override
    public void deleteLivre(long id) {
        livreRepository.deleteById(id);
    }
}
