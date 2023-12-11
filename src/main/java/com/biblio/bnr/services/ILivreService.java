package com.biblio.bnr.services;

import com.biblio.bnr.entity.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ILivreService {
    Page<Livre> retrieveLivres(Pageable pageable);
    Livre updateLivre (Livre livre);
    Livre addLivre (Livre livre);
    Optional<Livre> retrieveLivreById (long idLivre);

    void deleteLivre(long id);
}


