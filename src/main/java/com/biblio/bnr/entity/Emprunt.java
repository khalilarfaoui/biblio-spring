package com.biblio.bnr.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 20, nullable = false, unique = true)
    private String code = generateUniqueCode();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @OneToOne
    @JoinColumn(name = "livre_id", nullable = false, unique = true)
    private Livre livre;


    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    private String generateUniqueCode() {
        return UUID.randomUUID().toString().substring(0, 20);
    }


}
