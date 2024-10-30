package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(TransactionDAO.class);

    public TransactionDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addTransaction(Transaction transaction) {
        Transaction transactionObj = null;
        try (Session session = sessionFactory.openSession()) {
            transactionObj = session.beginTransaction();
            session.save(transaction);
            transactionObj.commit();
            return true;
        } catch (Exception e) {
            if (transactionObj != null) {
                transactionObj.rollback();
            }
            logger.error("Error adding transaction", e);
            return false;
        }
    }

    public Transaction getTransaction(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Transaction.class, id);
        } catch (Exception e) {
            logger.error("Error getting transaction", e);
            return null;
        }
    }

    public boolean updateTransaction(Transaction transaction) {
        Transaction transactionObj = null;
        try (Session session = sessionFactory.openSession()) {
            transactionObj = session.beginTransaction();
            session.update(transaction);
            transactionObj.commit();
            return true;
        } catch (Exception e) {
            if (transactionObj != null) {
                transactionObj.rollback();
            }
            logger.error("Error updating transaction", e);
            return false;
        }
    }

    public boolean deleteTransaction(long id) {
        Transaction transactionObj = null;
        try (Session session = sessionFactory.openSession()) {
            transactionObj = session.beginTransaction();
            Transaction transaction = session.get(Transaction.class, id);
            if (transaction != null) {
                session.delete(transaction);
                transactionObj.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transactionObj != null) {
                transactionObj.rollback();
            }
            logger.error("Error deleting transaction", e);
            return false;
        }
    }
}
