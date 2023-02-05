package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filmAdi;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<FilmKategori> filmKategorileri;
    @ManyToOne(cascade = CascadeType.ALL)
    private Yonetmen yonetmen;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Oyuncu> oyuncular;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Odul> oduller;


    public Film(String filmAdi, List<FilmKategori> filmKategorileri, List<Oyuncu> oyuncular, List<Odul> oduller) {
        this.filmAdi = filmAdi;
        this.filmKategorileri = filmKategorileri;
        this.oyuncular = oyuncular;
        this.oduller = oduller;
    }

    public Film(String filmAdi, List<FilmKategori> filmKategorileri, Yonetmen yonetmen, List<Odul> oduller) {
        this.filmAdi = filmAdi;
        this.filmKategorileri = filmKategorileri;
        this.yonetmen = yonetmen;
        this.oduller = oduller;
    }

    public Film(String filmAdi, List<FilmKategori> filmKategorileri, Yonetmen yonetmen, List<Oyuncu> oyuncular, List<Odul> oduller) {
        this.filmAdi = filmAdi;
        this.filmKategorileri = filmKategorileri;
        this.yonetmen = yonetmen;
        this.oyuncular = oyuncular;
        this.oduller = oduller;
    }

    public Film(String filmAdi, List<FilmKategori> filmKategorileri, Yonetmen yonetmen) {
        this.filmAdi = filmAdi;
        this.filmKategorileri = filmKategorileri;
        this.yonetmen = yonetmen;
    }
}
