package com.biblio.bnr.repositories;

import com.biblio.bnr.entity.FormatLivre;
import com.biblio.bnr.entity.GenreLivre;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.entity.PublicCible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByFormatLivre(FormatLivre formatLivre);

    List<Livre> findByPublicCible(PublicCible publicCible);

    List<Livre> findByGenreLivre(GenreLivre genreLivre);

    List<Livre> findByFormatLivreAndPublicCibleAndGenreLivre(
            FormatLivre formatLivre, PublicCible publicCible, GenreLivre genreLivre);

    List<Livre> findByFormatLivreAndPublicCible(FormatLivre formatLivre, PublicCible publicCible);

    List<Livre> findByFormatLivreAndGenreLivre(FormatLivre formatLivre, GenreLivre genreLivre);

    List<Livre> findByPublicCibleAndGenreLivre(PublicCible publicCible, GenreLivre genreLivre);
}
