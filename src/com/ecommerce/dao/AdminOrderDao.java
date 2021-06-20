package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.AdminOrder;
import com.ecommerce.utl.HibernateUtil;

public class AdminOrderDao {
	
	public static AdminOrder getOrder(int id) {
        Transaction transaction = null;
        AdminOrder order = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            order = session.get(AdminOrder.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return order;
    }

    @SuppressWarnings("unchecked")
    public static List <AdminOrder> getAllOrder() {
        Transaction transaction = null;
        List < AdminOrder > listOfOrder = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfOrder =  session.createQuery("from AdminOrder").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfOrder;
    }
}
