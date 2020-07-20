package com.stripe.tutorialstripe.controller;

import com.stripe.tutorialstripe.http.Mensaje;
import com.stripe.tutorialstripe.model.Articulo;
import com.stripe.tutorialstripe.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;

    @GetMapping("/lista")
    public ResponseEntity<List<Articulo>> lista() {
        List<Articulo> lista = articuloService.lista();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Articulo> detalle(@PathVariable("id") long id) {
        if (!articuloService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        Articulo articulo = articuloService.getById(id).get();
        return new ResponseEntity<>(articulo, HttpStatus.OK);
    }

}
