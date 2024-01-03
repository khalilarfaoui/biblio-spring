package com.biblio.bnr.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "livre_id", nullable = false, unique = true)
    private Livre livre;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;



}

