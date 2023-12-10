package com.biblio.bnr.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLivre")
    private long idLivre;
    private String titre;
    private String auteur;
    private Date dateDePublication;
    private int ISBN ;

    public Livre(){

    }

    public Livre(long idLivre, String titre, String auteur, Date dateDePublication, int ISBN) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.auteur = auteur;
        this.dateDePublication = dateDePublication;
        this.ISBN = ISBN;
    }

    public long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(long idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDateDePublication() {
        return dateDePublication;
    }

    public void setDateDePublication(Date dateDePublication) {
        this.dateDePublication = dateDePublication;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}



