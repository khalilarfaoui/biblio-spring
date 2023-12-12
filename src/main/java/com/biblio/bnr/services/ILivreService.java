package com.biblio.bnr.services;

import com.biblio.bnr.entity.FormatLivre;
import com.biblio.bnr.entity.GenreLivre;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.entity.PublicCible;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ILivreService {
    Page<Livre> retrieveLivres(Pageable pageable);
    Livre updateLivre (Livre livre);
    Livre addLivre (Livre livre);
    Optional<Livre> retrieveLivreById (long idLivre);
    List<Livre> getLivresByParams(FormatLivre formatLivre, PublicCible publicCible, GenreLivre genreLivre);
    void deleteLivre(long id);
}


