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
        Configuration configuration = new Configuration().configure(persistenceName);
        sessionFactory = configuration.buildSessionFactory();
    }

    public boolean addBuyer(Buyer buyer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(buyer);
            transaction.commit();
            logger.info("Buyer successfully saved");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error adding buyer", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Buyer getBuyer(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Buyer) session.get(Buyer.class, id);
        } catch (Exception e) {
            logger.error("Error getting buyer", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateBuyer(Buyer buyer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(buyer);
            transaction.commit();
            logger.info("Buyer successfully updated");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error updating buyer", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteBuyer(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Buyer buyer = (Buyer) session.get(Buyer.class, id);
            if (buyer != null) {
                session.delete(buyer);
                transaction.commit();
                logger.info("Buyer successfully deleted");
                return true;
            } else {
                logger.warn("Buyer not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error deleting buyer", e);
            return false;
        } finally {
            session.close();
        }
    }
}
