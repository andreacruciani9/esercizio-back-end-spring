package it.epicode.w6d2p.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    private String avatar;
    @OneToMany(mappedBy = "autore")
    private  BlogPost blogpost;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name="+nome+"+"+cognome;
    }


}
