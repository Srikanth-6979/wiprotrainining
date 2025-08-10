package com.wipro.hibernatedemo.repo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.hibernatedemo.entity.Pan1;
import com.wipro.hibernatedemo.util.HibernateUtil1;

public class HibernateRepo {

    public static void updatePan() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter pan id");
            int id = sc.nextInt();
            System.out.println("Please enter pan holder name:");
            String panHolderName = sc.next();
            System.out.println("Please enter pan number:");
            String panNumber = sc.next();

            Pan1 pd = new Pan1(id, panHolderName, panNumber);
            save(pd);
        }
    }

    public static void createPanHolder() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please enter pan holder name:");
            String panHolderName = sc.next();
            System.out.println("Please enter pan number:");
            String panNumber = sc.next();

            Pan1 pd = new Pan1(panHolderName, panNumber);
            save(pd);
        }
    }

    // insert and update
    public static void save(Pan1 pd) {
        Session session = HibernateUtil1.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        if (pd.getId() != 0) { // update
            Pan1 pd1 = findById(pd.getId());
            if (pd1 != null) {
                pd1.setPanHolderName(pd.getPanHolderName());
                pd1.setPanNumber(pd.getPanNumber());
                session.persist(pd1);
            } else {
                System.out.println("Pan record with ID " + pd.getId() + " not found.");
            }
        } else { // insert
            session.persist(pd);
        }

        transaction.commit();
    }

    public static Pan1 findById(int id) {
        Session session = HibernateUtil1.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Pan1 pd = session.find(Pan1.class, id);
        transaction.commit();
        return pd;
    }

    public static Pan1 deleteById(int id) {
        Session session = HibernateUtil1.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Pan1 pd = session.find(Pan1.class, id);
        if (pd != null) {
            session.remove(pd);
            transaction.commit();
        } else {
            System.out.println("Pan record not found.");
        }
        return pd;
    }

    public static List<Pan1> findAll() {
        Session session = HibernateUtil1.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hqlQuery = "from Pan1"; // corrected
        Query<Pan1> query = session.createQuery(hqlQuery, Pan1.class);
        List<Pan1> list = query.list();
        transaction.commit();
        return list;
    }

    public static List<String> findAllPanHolderNames() {
        Session session = HibernateUtil1.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hqlQuery = "SELECT panHolderName from Pan1";
        Query<String> query = session.createQuery(hqlQuery, String.class);
        List<String> list = query.list();
        transaction.commit();
        return list;
    }

    public static List<Pan1> findByPanNumbers(String panNumber) {
        Session session = HibernateUtil1.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hqlQuery = "from Pan1 where panNumber = :pNumber";
        Query<Pan1> query = session.createQuery(hqlQuery, Pan1.class);
        query.setParameter("pNumber", panNumber);
        List<Pan1> list = query.list();
        transaction.commit();
        return list;
    }
}
