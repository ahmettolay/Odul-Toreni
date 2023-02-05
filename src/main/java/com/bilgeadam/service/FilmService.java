package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.FilmDao;
import com.bilgeadam.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class FilmService {
    static FilmDao filmDao = new FilmDao();

    public static void main(String[] args) {
        save();
        //getAll();
    }

    public static void save() {
        FilmKategori filmKategori1 = new FilmKategori("Filmden Kaydedilen Kategori1");
        FilmKategori filmKategori2 = new FilmKategori("Filmden Kaydedilen Kategori2");
        List<FilmKategori> filmKategoriList = new ArrayList<>();
        filmKategoriList.add(filmKategori1);
        filmKategoriList.add(filmKategori2);

        Yonetmen yonetmen1 = new Yonetmen("Filmden Kaydedilen Yönetmen1");
        Oyuncu oyuncu1 = new Oyuncu("Filmden Kaydedilen Oyuncu1");
        Oyuncu oyuncu2 = new Oyuncu("Filmden Kaydedilen Oyuncu2");
        List<Oyuncu> oyuncuList = new ArrayList<>();
        oyuncuList.add(oyuncu1);
        oyuncuList.add(oyuncu2);

        Odul odul1 = new Odul("Filmden Kaydedilen Ödül1");
        Odul odul2 = new Odul("Filmden Kaydedilen Ödül2");
        List<Odul> fodulList = new ArrayList<>();
        fodulList.add(odul1);
        fodulList.add(odul2);

        Film film = new Film("Filmden Kaydedilen ÖÖdül Alan Film1", filmKategoriList, yonetmen1, oyuncuList, fodulList);
        filmDao.save(film);
    }
    public static  void getAll(){
        filmDao.getAllJDBC();
    }

}
