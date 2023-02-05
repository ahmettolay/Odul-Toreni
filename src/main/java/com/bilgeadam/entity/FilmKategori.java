package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FilmKategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kategoriAdi;


    public FilmKategori(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }
}
