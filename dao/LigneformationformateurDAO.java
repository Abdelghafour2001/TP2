package com.example.tp2.dao;

import com.example.tp2.models.Lieu;
import com.example.tp2.models.Ligneformationformateur;
import com.example.tp2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LigneformationformateurDAO {
    private SessionFactory sessionFactory;

    public LigneformationformateurDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Ligneformationformateur ligneformationformateur) {
        Transaction transaction = null;
        Session session = sessionFactory.getCurrentSession();
        try{
            transaction = session.beginTransaction();
            session.save(ligneformationformateur);
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


    public List<Ligneformationformateur> getAll() {
        Session session = sessionFactory.getCurrentSession();
        try  {
            Query<Ligneformationformateur> query = session.createQuery("from Ligneformationformateur ", Ligneformationformateur.class);
            List<Ligneformationformateur> lieux = query.list();
            return lieux;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
