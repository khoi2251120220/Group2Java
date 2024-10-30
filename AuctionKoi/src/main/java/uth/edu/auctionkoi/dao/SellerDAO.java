package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Seller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellerDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(SellerDAO.class);

    public SellerDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addSeller(Seller seller) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(seller);
            transaction.commit();
            logger.info("Seller successfully added");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding seller", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Seller getSeller(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Seller) session.get(Seller.class, id);
        } catch (Exception e) {
            logger.error("Error getting seller", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateSeller(Seller seller) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(seller);
            transaction.commit();
            logger.info("Seller successfully updated");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating seller", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteSeller(long id) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Seller seller = (Seller) session.get(Seller.class, id);
            if (seller != null) {
                session.delete(seller);
                transaction.commit();
                logger.info("Seller successfully deleted");
                return true;
            } else {
                logger.warn("Seller not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting seller", e);
            return false;
        } finally {
            session.close();
        }
    }
}
