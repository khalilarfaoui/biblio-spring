package com.biblio.bnr.controllers;

import com.biblio.bnr.entity.Emprunt;

import com.biblio.bnr.entity.Livre;
import com.biblio.bnr.services.EmpruntService;
import com.biblio.bnr.services.QRCodeService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping
    public List<Emprunt> getAllEmprunts() {
        return empruntService.getAllEmprunts();
    }

    @GetMapping("/byUsername/{username}")
    public List<Emprunt> getEmpruntsByUsername(@PathVariable String username) {
        return empruntService.getEmpruntsByUsername(username);
    }



    @GetMapping("/{id}")
    public Emprunt getEmpruntById(@PathVariable Long id) {
        return empruntService.getEmpruntById(id);
    }

    @PostMapping
    public Emprunt createEmprunt(@RequestBody Emprunt emprunt) {
        return empruntService.createEmprunt(emprunt);
    }

    @PutMapping("/{id}")
    public Emprunt updateEmprunt(@PathVariable Long id, @RequestBody Emprunt updatedEmprunt) {
        return empruntService.updateEmprunt(id, updatedEmprunt);
    }

    @GetMapping("/byLivre")
    public List<Emprunt> getEmpruntsByLivre(@RequestParam Long livreId) {
        Livre livre = new Livre();
        livre.setIdLivre(livreId);
        return empruntService.getEmpruntsByLivre(livre);
    }

    @GetMapping("/byCode/{code}")
    public Optional<Emprunt> getEmpruntByCode(@PathVariable String code) {
        return empruntService.getEmpruntByCode(code);
    }

    @DeleteMapping("/{id}")
    public void deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
    }

    @GetMapping("/qrcode")
    public void generateQRCode(HttpServletResponse response,
                               @RequestParam String text,
                               @RequestParam(defaultValue = "350") int width,
                               @RequestParam(defaultValue = "350") int height) throws Exception {
        BufferedImage image = qrCodeService.generateQRCode(text, width, height);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }
}