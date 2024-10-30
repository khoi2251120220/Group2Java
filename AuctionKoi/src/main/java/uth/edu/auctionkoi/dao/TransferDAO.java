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
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(transfer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding transfer", e);
            return false;
        }
    }

    public Transfer getTransfer(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Transfer.class, id);
        } catch (Exception e) {
            logger.error("Error getting transfer", e);
            return null;
        }
    }

    public boolean updateTransfer(Transfer transfer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(transfer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating transfer", e);
            return false;
        }
    }

    public boolean deleteTransfer(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Transfer transfer = session.get(Transfer.class, id);
            if (transfer != null) {
                session.delete(transfer);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting transfer", e);
            return false;
        }
    }
}
