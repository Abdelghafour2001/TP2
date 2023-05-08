package com.example.tp2.dao;

import java.util.List;

import com.example.tp2.models.Formation;
import com.example.tp2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class FormationDAO {

    private SessionFactory sessionFactory;

    public FormationDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Formation formation) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            session.save(formation);
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

    public void update(Formation formation) {
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
    }

    public Formation getById(int formationId) {
        Session session = sessionFactory.openSession();
        try{
            Formation formation = session.get(Formation.class, formationId);
            return formation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    public List<Formation> getAll() {
        Session session = sessionFactory.openSession();
        try  {
            Query<Formation> query = session.createQuery("from Formation", Formation.class);
            List<Formation> formations = query.list();
            return formations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
