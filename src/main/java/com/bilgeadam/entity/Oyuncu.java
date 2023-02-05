package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Oyuncu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String oyuncuAdSoyad;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Film>  filmler;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Odul>  oduller;

    public Oyuncu(String adSoyad) {
        this.oyuncuAdSoyad = adSoyad;
    }

    public Oyuncu(String adSoyad, List<Film> filmler, List<Odul> oduller) {
        this.oyuncuAdSoyad = adSoyad;
        this.filmler = filmler;
        this.oduller = oduller;
    }
}
