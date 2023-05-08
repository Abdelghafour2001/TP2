package com.example.tp2.dao;

import com.example.tp2.models.Formation;
import com.example.tp2.models.Lieu;
import com.example.tp2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LieuDAO {
    private SessionFactory sessionFactory;

    public LieuDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Lieu lieu) {
        Transaction transaction = null;
        Session session = sessionFactory.getCurrentSession();
        try{
            transaction = session.beginTransaction();
            session.save(lieu);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

  /*  public void update(Formation formation) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(formation);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(int formationId) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Formation formation = session.get(Formation.class, formationId);
            if (formation != null) {
                session.delete(formation);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/

    public Lieu getById(int lieuId) {
        Session session = sessionFactory.openSession();
        try{
            Lieu lieu = session.get(Lieu.class, lieuId);
            return lieu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public List<Lieu> getAll() {
        Session session = sessionFactory.getCurrentSession();
        try  {
            Query<Lieu> query = session.createQuery("from Lieu ", Lieu.class);
            List<Lieu> lieux = query.list();
            return lieux;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
