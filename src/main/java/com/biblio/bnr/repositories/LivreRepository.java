package com.biblio.bnr.repositories;

import com.biblio.bnr.entity.FormatLivre;
import com.biblio.bnr.entity.GenreLivre;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.entity.PublicCible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    List<Livre> findByEmpruntIsNotNull();

    List<Livre> findByEmpruntIsNull();

    List<Livre> findByEmpruntIsNullAndReservationIsNull();

    List<Livre> findByEmpruntIsNotNullAndReservationIsNull();

    @Query("SELECT l.formatLivre, COUNT(l) FROM Livre l GROUP BY l.formatLivre")
    List<Object[]> countBooksByFormatLivre();

    @Query("SELECT l.genreLivre, COUNT(l) FROM Livre l GROUP BY l.genreLivre")
    List<Object[]> countBooksByGenreLivre();
}
