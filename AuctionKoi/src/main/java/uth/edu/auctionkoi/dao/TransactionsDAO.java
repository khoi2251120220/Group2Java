package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uth.edu.auctionkoi.pojo.Transactions;

public class TransactionsDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(TransactionsDAO.class);

    public TransactionsDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addTransactions(Transactions transactions) {
        Session session = sessionFactory.openSession();
        Transaction transactionObj = session.beginTransaction();
        try {
            session.save(transactions);
            transactionObj.commit();
            logger.info("Transaction successfully saved");
            return true;
        } catch (Exception e) {
            transactionObj.rollback();
            logger.error("Error adding transaction", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Transactions getTransaction(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Transactions) session.get(Transactions.class, id);
        } catch (Exception e) {
            logger.error("Error getting transaction", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateTransactions(Transactions transactions) {
        Session session = sessionFactory.openSession();
        Transaction transactionObj = session.beginTransaction();
        try {
            session.update(transactions);
            transactionObj.commit();
            logger.info("Transaction successfully updated");
            return true;
        } catch (Exception e) {
            transactionObj.rollback();
            logger.error("Error updating transaction", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteTransactions(long id) {
        Session session = sessionFactory.openSession();
        Transaction transactionObj = session.beginTransaction();
        try {
            Transactions transactions = (Transactions) session.get(Transactions.class, id);
            if (transactions != null) {
                session.delete(transactions);
                transactionObj.commit();
                logger.info("Transaction successfully deleted");
                return true;
            } else {
                logger.warn("Transaction not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transactionObj.rollback();
            logger.error("Error deleting transaction", e);
            return false;
        } finally {
            session.close();
        }
    }
}
