package com.bilgeadam.repository;


import com.bilgeadam.entity.Oyuncu;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;


import java.util.List;

public class OyuncuDao implements ICrud<Oyuncu> {
    public void save(Oyuncu oyuncu) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(oyuncu);
            session.getTransaction().commit();
            System.out.println("Oyuncu data is added");
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void update(Oyuncu oyuncu) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(oyuncu);
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
        Oyuncu oyuncu = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            oyuncu = session.load(Oyuncu.class, id);
            session.delete(oyuncu);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public void odulAlanOyuncular(String filmAdi) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT oy.oyuncuAdSoyad FROM  oyuncu AS oy\n" +
                    "        INNER JOIN oyuncu_film AS o_f ON o_f.Oyuncu_id=oy.id\n" +
                    "        INNER JOIN film AS f ON f.id=o_f.filmler_id WHERE filmAdi= ?";

            NativeQuery query = session.createNativeQuery(sql);
            query.setParameter(1,filmAdi);
            List<Object> array = query.getResultList();
            session.getTransaction().commit();
            session.close();
         /*   if(array.size()>0){
                System.out.println(array);
            }else {
               System.out.println("'" +filmAdi+"'" + " filminden ödül alan oyuncu yoktur.");
            }*/

            System.out.println(array.size()>0 ? array :"'" +filmAdi+"'" + " filminden ödül alan oyuncu yoktur." );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
