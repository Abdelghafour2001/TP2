package com.example.tp2.dao;

import java.util.List;

import com.example.tp2.models.Formateur;
import com.example.tp2.models.Lieu;
import com.example.tp2.util.HibernateUtil;

import org.hibernate.*;
import org.hibernate.query.Query;


public class FormateurDAO {

    private SessionFactory sessionFactory;

    public FormateurDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Formateur lieu) {
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

    public void update(Formateur formateur) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(formateur);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(String formateurCin) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Formateur formateur = session.get(Formateur.class, formateurCin);
            if (formateur != null) {
                session.delete(formateur);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Formateur getById(String formateurCin) {
        try (Session session = sessionFactory.openSession()) {
            Formateur formateur = session.get(Formateur.class, formateurCin);
            return formateur;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Formateur> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Formateur> query = session.createQuery("from Formateur", Formateur.class);
            List<Formateur> formateurs = query.list();
            return formateurs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
