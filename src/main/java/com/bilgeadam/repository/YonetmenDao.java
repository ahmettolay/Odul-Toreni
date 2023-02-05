package com.bilgeadam.repository;

import com.bilgeadam.entity.Film;
import com.bilgeadam.entity.Yonetmen;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

public class YonetmenDao implements  ICrud<Yonetmen> {


    public  void save(Yonetmen yonetmen){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(yonetmen);
            session.getTransaction().commit();
            System.out.println("Yonetmen data is added");
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void update(Yonetmen yonetmen) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(yonetmen);
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
        Yonetmen yonetmen = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            yonetmen = session.load(Yonetmen.class, id);
            session.delete(yonetmen);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

}
