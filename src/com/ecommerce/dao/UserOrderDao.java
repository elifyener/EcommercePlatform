package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecommerce.model.UserOrder;
import com.ecommerce.utl.HibernateUtil;
public class UserOrderDao {

	public static UserOrder getOrder(int id) {
        Transaction transaction = null;
        UserOrder order = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            order = session.get(UserOrder.class, id);
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
    public static List <UserOrder> getAllOrder(int id) {
        Transaction transaction = null;
        List < UserOrder > listOfOrder = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listOfOrder =  session.createQuery("FROM UserOrder U WHERE U.ordernum = :id").setParameter("id", id).getResultList();
            // commit transaction
            System.out.println(listOfOrder+"deneme");
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
