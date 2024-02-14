package it.epicode.w6d2p.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Random;
@Entity
@Data
public class BlogPost {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private int id ;
    private String contenuto;
    private String titolo;
    private String cover = "https://picsum.photos/200/300";
    private String categoria;
    private int tempoLettura;
    @ManyToOne
    @JoinColumn(name = "autorefk")
    private Autore autore;
}
