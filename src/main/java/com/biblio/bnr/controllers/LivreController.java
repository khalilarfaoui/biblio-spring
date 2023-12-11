package com.biblio.bnr.controllers;

import com.biblio.bnr.entity.FormatLivre;
import com.biblio.bnr.entity.GenreLivre;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.entity.PublicCible;
import com.biblio.bnr.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/public/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.retrieveLivres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable long id) {
        Optional<Livre> livre = livreService.retrieveLivreById(id);
        return livre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Livre> saveLivre(@RequestBody Livre livre) {
        Livre savedLivre = livreService.addLivre(livre);
        return new ResponseEntity<>(savedLivre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable long id, @RequestBody Livre livre) {
        if (!livreService.retrieveLivreById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        livre.setIdLivre(id);
        Livre updatedLivre = livreService.addLivre(livre);
        return new ResponseEntity<>(updatedLivre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable long id) {
        if (!livreService.retrieveLivreById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        livreService.deleteLivre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/retrieve-all-formatLivre")
    @ResponseBody
    public FormatLivre[] getFormatLivre() {
        return FormatLivre.values();
    }

    @GetMapping("/retrieve-all-genreLivre")
    @ResponseBody
    public GenreLivre[] getGenreLivre() {
        return GenreLivre.values();
    }

    @GetMapping("/retrieve-all-publicCible")
    @ResponseBody
    public PublicCible[] getPublicCible() {
        return PublicCible.values();
    }
}
