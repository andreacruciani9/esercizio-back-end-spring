package it.epicode.w6d2p.service;

import it.epicode.w6d2p.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AutoreService {

    private List<Autore> autori = new ArrayList<>();


    public List<Autore> cercaTuttiGliAutori(){
        return autori;
    }

    public Autore cercaAutorePerId(int id){
        return autori.stream().filter(autore -> autore.getId()==id).findAny().
                orElseThrow(()->new NoSuchElementException("Autore non trovato"));
    }

    public Autore salvaAutore(Autore autore){
        autori.add(autore);
        return autore;
    }

    public Autore aggiornaAutore(int id, Autore autore) throws NoSuchElementException{
        Autore a = cercaAutorePerId(id);

        a.setNome(autore.getNome());
        a.setCognome(autore.getCognome());
        a.setEmail(autore.getEmail());
        a.setDataNascita(autore.getDataNascita());

        return a;
    }

    public void cancellaAutore(int id) throws NoSuchElementException{
        Autore a = cercaAutorePerId(id);

        autori.remove(a);
    }
}
