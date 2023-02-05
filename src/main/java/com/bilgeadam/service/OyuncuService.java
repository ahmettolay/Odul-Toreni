package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.OyuncuDao;

import java.util.ArrayList;
import java.util.List;

public class OyuncuService {
    static OyuncuDao oyuncuDao = new OyuncuDao();

    public static void main(String[] args) {
//save();
        odulAlanOyuncular("Oyuncudann Kaydedilen Film");
    }

    public static void save() {
        FilmKategori filmKategori1 = new FilmKategori("Oyuncudan Kaydedilen Kategori1");
        FilmKategori filmKategori2 = new FilmKategori("Oyuncudan Kaydedilen Kategori2");
        List<FilmKategori> filmKategoriList = new ArrayList<>();
        filmKategoriList.add(filmKategori1);
        filmKategoriList.add(filmKategori2);

        Odul odul1 = new Odul("Oyuncudan Kaydedilen Odul1");
        Odul odul2 = new Odul("Oyuncudan Kaydedilen Odul2");
        List<Odul> yodulList = new ArrayList<>();
        yodulList.add(odul1);
        yodulList.add(odul2);

        Yonetmen yonetmen = new Yonetmen("Oyuncudan Kaydedilen Yonetmen");

        Film film1 = new Film("Oyuncudan Kaydedilen Film", filmKategoriList, yonetmen);
        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);

        Odul odul5 = new Odul("Oyuncudan Kaydedilen Odul");
        Odul odul6 = new Odul("Oyuncudan Kaydedilen Odul");
        List<Odul> oodulList = new ArrayList<>();
        oodulList.add(odul5);
        oodulList.add(odul6);
        Oyuncu oyuncu = new Oyuncu("Oyuncudan Kaydedilen Ödül Alan Oyuncu", filmList, oodulList);
        oyuncuDao.save(oyuncu);
    }

    public  static  void   odulAlanOyuncular(String filmAdi){
        oyuncuDao.odulAlanOyuncular(filmAdi);
    }
}
