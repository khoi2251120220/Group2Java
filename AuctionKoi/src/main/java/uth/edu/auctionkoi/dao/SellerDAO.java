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
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(seller);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding seller", e);
            return false;
        }
    }

    public Seller getSeller(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Seller.class, id);
        } catch (Exception e) {
            logger.error("Error getting seller", e);
            return null;
        }
    }

    public boolean updateSeller(Seller seller) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(seller);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating seller", e);
            return false;
        }
    }

    public boolean deleteSeller(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Seller seller = session.get(Seller.class, id);
            if (seller != null) {
                session.delete(seller);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting seller", e);
            return false;
        }
    }
}
