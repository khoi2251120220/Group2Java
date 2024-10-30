package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyerDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(BuyerDAO.class);

    public BuyerDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addBuyer(Buyer buyer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(buyer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding buyer", e);
            return false;
        }
    }

    public Buyer getBuyer(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Buyer.class, id);
        } catch (Exception e) {
            logger.error("Error getting buyer", e);
            return null;
        }
    }

    public boolean updateBuyer(Buyer buyer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(buyer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating buyer", e);
            return false;
        }
    }

    public boolean deleteBuyer(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            if (buyer != null) {
                session.delete(buyer);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting buyer", e);
            return false;
        }
    }
}
