package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Koi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KoiDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(KoiDAO.class);

    public KoiDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addKoi(Koi koi) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(koi);
            transaction.commit();
            logger.info("Koi successfully added");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding koi", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Koi getKoi(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Koi) session.get(Koi.class, id);
        } catch (Exception e) {
            logger.error("Error getting koi", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateKoi(Koi koi) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(koi);
            transaction.commit();
            logger.info("Koi successfully updated");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating koi", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteKoi(long id) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Koi koi = (Koi) session.get(Koi.class, id);
            if (koi != null) {
                session.delete(koi);
                transaction.commit();
                logger.info("Koi successfully deleted");
                return true;
            } else {
                logger.warn("Koi not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting koi", e);
            return false;
        } finally {
            session.close();
        }
    }
}
