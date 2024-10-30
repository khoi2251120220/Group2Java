package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(TransferDAO.class);

    public TransferDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addTransfer(Transfer transfer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(transfer);
            transaction.commit();
            logger.info("Transfer successfully saved");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error adding transfer", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Transfer getTransfer(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Transfer) session.get(Transfer.class, id);
        } catch (Exception e) {
            logger.error("Error getting transfer", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateTransfer(Transfer transfer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(transfer);
            transaction.commit();
            logger.info("Transfer successfully updated");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error updating transfer", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteTransfer(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Transfer transfer = (Transfer) session.get(Transfer.class, id);
            if (transfer != null) {
                session.delete(transfer);
                transaction.commit();
                logger.info("Transfer successfully deleted");
                return true;
            } else {
                logger.warn("Transfer not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error deleting transfer", e);
            return false;
        } finally {
            session.close();
        }
    }
}
