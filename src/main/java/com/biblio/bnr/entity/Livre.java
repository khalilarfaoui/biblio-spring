package com.biblio.bnr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Livre")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLivre")
    private long idLivre;
    private String titre;
    private String auteur;
    private Date dateDePublication;
    private int ISBN;

    private FormatLivre formatLivre;
    private PublicCible publicCible;
    private GenreLivre genreLivre;

    @JsonIgnore
    @OneToOne(mappedBy = "livre", cascade = CascadeType.ALL)
    private Emprunt emprunt;

    @JsonIgnore
    @OneToOne(mappedBy = "livre", cascade = CascadeType.ALL)
    private Reservation reservation;


}



