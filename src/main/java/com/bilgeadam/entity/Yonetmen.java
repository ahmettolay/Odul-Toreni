package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Yonetmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String yonetmenAdSoyad;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Film>  filmler;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Odul>  oduller;


    public Yonetmen(String adSoyad) {
        this.yonetmenAdSoyad = adSoyad;
    }

    public Yonetmen(String adSoyad, List<Film> filmler, List<Odul> oduller) {
        this.yonetmenAdSoyad = adSoyad;
        this.filmler = filmler;
        this.oduller = oduller;
    }

    public Yonetmen(String adSoyad, List<Odul> oduller) {
        this.yonetmenAdSoyad = adSoyad;
        this.oduller = oduller;
    }
}
