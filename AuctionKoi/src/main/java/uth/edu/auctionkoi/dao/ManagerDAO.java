package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagerDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(ManagerDAO.class);

    public ManagerDAO(String persistenceName) {
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addManager(Manager manager) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(manager);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding manager", e);
            return false;
        }
    }

    public Manager getManager(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Manager.class, id);
        } catch (Exception e) {
            logger.error("Error getting manager", e);
            return null;
        }
    }

    public boolean updateManager(Manager manager) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(manager);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating manager", e);
            return false;
        }
    }

    public boolean deleteManager(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Manager manager = session.get(Manager.class, id);
            if (manager != null) {
                session.delete(manager);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting manager", e);
            return false;
        }
    }
}
