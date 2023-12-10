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

    private FormatLivre formatLivre ;
    private PublicCible publicCible ;
    private GenreLivre genreLivre ;

    public Livre(){

    }

    public Livre(long idLivre, String titre, String auteur, Date dateDePublication, int ISBN, FormatLivre formatLivre, PublicCible publicCible, GenreLivre genreLivre) {
        this.idLivre = idLivre;
        this.titre = titre;
        this.auteur = auteur;
        this.dateDePublication = dateDePublication;
        this.ISBN = ISBN;
        this.formatLivre = formatLivre;
        this.publicCible = publicCible;
        this.genreLivre = genreLivre;
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

    public FormatLivre getFormatLivre() {
        return formatLivre;
    }

    public void setFormatLivre(FormatLivre formatLivre) {
        this.formatLivre = formatLivre;
    }

    public PublicCible getPublicCible() {
        return publicCible;
    }

    public void setPublicCible(PublicCible publicCible) {
        this.publicCible = publicCible;
    }

    public GenreLivre getGenreLivre() {
        return genreLivre;
    }

    public void setGenreLivre(GenreLivre genreLivre) {
        this.genreLivre = genreLivre;
    }
}



