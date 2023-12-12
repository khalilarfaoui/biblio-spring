package com.biblio.bnr.controllers;

import com.biblio.bnr.entity.FormatLivre;
import com.biblio.bnr.entity.GenreLivre;
import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.entity.PublicCible;
import com.biblio.bnr.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;

    // http://localhost:8081/livres?page=0&size=3
    @GetMapping
    public Page<Livre> getAllLivres(Pageable pageable) {
        return livreService.retrieveLivres(pageable);
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

    // http://localhost:8081/livres/byParams?formatLivre=POCHE&publicCible=ENFANTS&genreLivre=ROMANS

    @GetMapping("/byParams")
    public ResponseEntity<List<Livre>> getLivresByParams(
            @RequestParam(name = "formatLivre", required = false) FormatLivre formatLivre,
            @RequestParam(name = "publicCible", required = false) PublicCible publicCible,
            @RequestParam(name = "genreLivre", required = false) GenreLivre genreLivre) {

        List<Livre> livres = livreService.getLivresByParams(formatLivre, publicCible, genreLivre);

        if (livres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(livres, HttpStatus.OK);
    }
}
