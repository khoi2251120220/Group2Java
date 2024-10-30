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
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(manager);
            transaction.commit();
            logger.info("Manager successfully added");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding manager", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Manager getManager(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Manager) session.get(Manager.class, id);
        } catch (Exception e) {
            logger.error("Error getting manager", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateManager(Manager manager) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(manager);
            transaction.commit();
            logger.info("Manager successfully updated");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating manager", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteManager(long id) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Manager manager = (Manager) session.get(Manager.class, id);
            if (manager != null) {
                session.delete(manager);
                transaction.commit();
                logger.info("Manager successfully deleted");
                return true;
            } else {
                logger.warn("Manager not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting manager", e);
            return false;
        } finally {
            session.close();
        }
    }
}
