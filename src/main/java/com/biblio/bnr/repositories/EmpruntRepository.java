package com.biblio.bnr.repositories;


import com.biblio.bnr.entity.Emprunt;
import com.biblio.bnr.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    List<Emprunt> findByUserUsername(String username);
    List<Emprunt> findByLivre(Livre livre);
    Optional<Emprunt> findByCode(String code);
}
