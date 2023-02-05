package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.YonetmenDao;

import java.util.ArrayList;
import java.util.List;

public class YomentmenDao {
    static YonetmenDao yonetmenDao = new YonetmenDao();

    public static void main(String[] args) {
        save();
    }

    public static void save() {
        FilmKategori filmKategori1 = new FilmKategori("Yönetmenden Kaydedilen Kategori1");
        FilmKategori filmKategori2 = new FilmKategori("Yönetmenden Kaydedilen Kategori2");
        List<FilmKategori> filmKategoriList = new ArrayList<>();
        filmKategoriList.add(filmKategori1);
        filmKategoriList.add(filmKategori2);
        Oyuncu oyuncu1 = new Oyuncu("Yönetmenden Kaydedilen Oyuncu1");
        Oyuncu oyuncu2 = new Oyuncu("Yönetmenden Kaydedilen Oyuncu2");
        List<Oyuncu> oyuncuList = new ArrayList<>();
        Odul odul1 = new Odul("Yönetmenden Kaydedilen Odul1");
        Odul odul2 = new Odul("Yönetmenden Kaydedilen Odul2");
        List<Odul> odulList1 = new ArrayList<>();
        odulList1.add(odul1);

        Film film1 = new Film("Yönetmenden Kaydedilen Film1", filmKategoriList, oyuncuList, odulList1);

        FilmKategori filmKategori3 = new FilmKategori("Yönetmenden Kaydedilen Kategori3");
        FilmKategori filmKategori4 = new FilmKategori("Yönetmenden Kaydedilen Kategori4");
        List<FilmKategori> filmKategoriList2 = new ArrayList<>();
        filmKategoriList2.add(filmKategori4);
        filmKategoriList2.add(filmKategori3);
        List<Odul> odulList2 = new ArrayList<>();
        odulList2.add(odul2);
        Oyuncu oyuncu3 = new Oyuncu("Yönetmenden Kaydedilen Oyuncu3");
        Oyuncu oyuncu4 = new Oyuncu("Yönetmenden Kaydedilen Oyuncu4");
        List<Oyuncu> oyuncuList2 = new ArrayList<>();
        oyuncuList2.add(oyuncu3);
        oyuncuList2.add(oyuncu4);

        Film film2 = new Film("Yönetmenden Kaydedilen Film2", filmKategoriList2, oyuncuList2, odulList2);
        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);
        filmList.add(film2);

        Yonetmen yonetmen = new Yonetmen("Yönetmenden Kaydedilen Ödül Alan Yönetmen1", filmList, odulList2);
        yonetmenDao.save(yonetmen);
    }

}
