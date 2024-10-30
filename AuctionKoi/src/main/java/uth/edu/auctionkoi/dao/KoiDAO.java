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
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(koi);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding koi", e);
            return false;
        }
    }

    public Koi getKoi(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Koi.class, id);
        } catch (Exception e) {
            logger.error("Error getting koi", e);
            return null;
        }
    }

    public boolean updateKoi(Koi koi) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(koi);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating koi", e);
            return false;
        }
    }

    public boolean deleteKoi(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Koi koi = session.get(Koi.class, id);
            if (koi != null) {
                session.delete(koi);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting koi", e);
            return false;
        }
    }
}
