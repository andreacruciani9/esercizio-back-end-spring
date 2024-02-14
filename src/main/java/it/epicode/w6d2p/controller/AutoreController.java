package it.epicode.w6d2p.controller;

import it.epicode.w6d2p.model.Autore;
import it.epicode.w6d2p.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;
    @GetMapping("/autori")
    public List<Autore> getAll(){
        return autoreService.cercaTuttiGliAutori();
    }
    @GetMapping("/autori/{id}")
    public ResponseEntity<Autore> getAutoreById(@PathVariable int id){
        try {
            Autore autore = autoreService.cercaAutorePerId(id);
            return new ResponseEntity<Autore>(autore, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Autore>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/autori")
    public Autore saveAutore(@RequestBody Autore autore){
        return autoreService.salvaAutore(autore);
    }
    @PutMapping("/autori/{id}")
    public ResponseEntity<Autore> updateAutore(@PathVariable int id, @RequestBody Autore autore){
        try{
            Autore a = autoreService.aggiornaAutore(id, autore);
            return new ResponseEntity<Autore>(a, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Autore>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/autori/{id}")
    public ResponseEntity<String> deleteAutore(@PathVariable int id){
        try{
            autoreService.cancellaAutore(id);
            return new ResponseEntity<String>("Autore con id=" + id +" cancellato", HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }


}
