package com.biblio.bnr.services;

import com.biblio.bnr.entity.FormatLivre;
import com.biblio.bnr.entity.GenreLivre;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.entity.PublicCible;
import com.biblio.bnr.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService implements ILivreService {

    @Autowired
    private LivreRepository livreRepository;

    // http://localhost:8081/livres?page=0&size=3
    @Override
    public Page<Livre> retrieveLivres(Pageable pageable) {
        return livreRepository.findAll(pageable);
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

    // http://localhost:8081/livres/byParams?formatLivre=POCHE&publicCible=ENFANTS&genreLivre=ROMANS
    @Override
    public List<Livre> getLivresByParams(FormatLivre formatLivre, PublicCible publicCible, GenreLivre genreLivre) {
        if (formatLivre != null && publicCible != null && genreLivre != null) {
            return livreRepository.findByFormatLivreAndPublicCibleAndGenreLivre(formatLivre, publicCible, genreLivre);
        } else if (formatLivre != null && publicCible != null) {
            return livreRepository.findByFormatLivreAndPublicCible(formatLivre, publicCible);
        } else if (formatLivre != null && genreLivre != null) {
            return livreRepository.findByFormatLivreAndGenreLivre(formatLivre, genreLivre);
        } else if (publicCible != null && genreLivre != null) {
            return livreRepository.findByPublicCibleAndGenreLivre(publicCible, genreLivre);
        } else if (formatLivre != null) {
            return livreRepository.findByFormatLivre(formatLivre);
        } else if (publicCible != null) {
            return livreRepository.findByPublicCible(publicCible);
        } else if (genreLivre != null) {
            return livreRepository.findByGenreLivre(genreLivre);
        } else {
            return livreRepository.findAll();
        }
    }
}
