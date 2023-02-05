package com.bilgeadam.utils;





import com.bilgeadam.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        try {

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Film.class);
            configuration.addAnnotatedClass(Odul.class);
            configuration.addAnnotatedClass(Oyuncu.class);
            configuration.addAnnotatedClass(Yonetmen.class);
            configuration.addAnnotatedClass(FilmKategori.class);
            sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e){
            e.printStackTrace();
        }

        return sessionFactory;
    }


}
