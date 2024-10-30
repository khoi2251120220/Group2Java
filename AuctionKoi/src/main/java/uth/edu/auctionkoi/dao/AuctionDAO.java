package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Auction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuctionDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(AuctionDAO.class);

    public AuctionDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addAuction(Auction auction) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(auction);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding auction", e);
            return false;
        }
    }

    public Auction getAuction(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Auction.class, id);
        } catch (Exception e) {
            logger.error("Error getting auction", e);
            return null;
        }
    }

    public boolean updateAuction(Auction auction) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(auction);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating auction", e);
            return false;
        }
    }

    public boolean deleteAuction(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Auction auction = session.get(Auction.class, id);
            if (auction != null) {
                session.delete(auction);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting auction", e);
            return false;
        }
    }
}
