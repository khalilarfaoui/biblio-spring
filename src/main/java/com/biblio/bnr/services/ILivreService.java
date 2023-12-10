package com.biblio.bnr.services;

import com.biblio.bnr.entity.Livre;

import java.util.List;
import java.util.Optional;

public interface ILivreService {
    List<Livre> retrieveLivres();
    Livre updateLivre (Livre livre);
    Livre addLivre (Livre livre);
    Optional<Livre> retrieveLivreById (long idLivre);

    void deleteLivre(long id);
}


