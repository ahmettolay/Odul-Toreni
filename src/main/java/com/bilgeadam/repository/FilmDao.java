package com.bilgeadam.repository;

import com.bilgeadam.entity.Film;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class FilmDao implements  ICrud<Film> {

    public void save(Film film) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            System.out.println("Film data is added");
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(Film film) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(film);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        Session session = null;
        Film film = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            film = session.load(Film.class, id);
            session.delete(film);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            //rollback kontrolü yapılabilir
        }
    }

    public void getAllJDBC() {
        List<Object[]> filmList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT f.filmAdi,fk.kategoriAdi,y.yonetmenAdSoyad ,od.odulAdi,o.oyuncuAdSoyad FROM odultoreni.film AS f\n" +
                    "INNER JOIN odultoreni.film_filmkategori AS ff ON ff.Film_id=f.id\n" +
                    "INNER JOIN odultoreni.filmkategori AS fk ON fk.id=ff.filmKategorileri_id\n" +
                    "INNER JOIN odultoreni.yonetmen AS y ON y.id=f.yonetmen_id\n" +
                    "INNER JOIN odultoreni.film_oyuncu AS fo ON fo.Film_id=f.id\n" +
                    "INNER JOIN odultoreni.oyuncu AS o ON o.id=fo.oyuncular_id\n" +
                    "INNER JOIN odultoreni.film_odul AS fodul ON fodul.Film_id=f.id\n" +
                    "INNER JOIN odultoreni.odul AS od ON od.id=fodul.oduller_id";
            filmList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : filmList) {
                System.out.println("ID: " + item[0] + " --"
                        + " Book Name: " + item[1] + " --"
                        + " Name: " + item[2] + " "
                        + " Name: " + item[3] + " --"
                        + " Description: " + item[4] + " --"
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Film> getAllHQL() {
        List<Film> filmList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            filmList = session.createQuery("select film from Film film").list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return  filmList;
    }




}
