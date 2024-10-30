package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Auction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AuctionDAO {
    private SessionFactory sessionFactory;
    private Configuration configuration;
    private static final Logger logger = LoggerFactory.getLogger(AuctionDAO.class);

    public AuctionDAO(String persistenceName) {
        configuration = new Configuration().configure(persistenceName);
        sessionFactory = configuration.buildSessionFactory();
    }

    public boolean addAuction(Auction auction) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(auction);
            transaction.commit();
            logger.info("Auction successfully saved");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error adding auction", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Auction getAuction(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Auction) session.get(Auction.class, id);
        } catch (Exception e) {
            logger.error("Error getting auction", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateAuction(Auction auction) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(auction);
            transaction.commit();
            logger.info("Auction successfully updated");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error updating auction", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteAuction(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Auction auction = (Auction) session.get(Auction.class, id);
            if (auction != null) {
                session.delete(auction);
                transaction.commit();
                logger.info("Auction successfully deleted");
                return true;
            } else {
                logger.warn("Auction not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error deleting auction", e);
            return false;
        } finally {
            session.close();
        }
    }
}
