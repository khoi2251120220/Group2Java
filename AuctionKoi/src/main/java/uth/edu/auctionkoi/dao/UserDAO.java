package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@Repository
public class UserDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
            logger.info("User successfully saved");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error adding user", e);
            return false;
        } finally {
            session.close();
        }
    }

    public User getUser(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (User) session.get(User.class, id);
        } catch (Exception e) {
            logger.error("Error getting user", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
            logger.info("User successfully updated");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error updating user", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteUser(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = (User) session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                transaction.commit();
                logger.info("User successfully deleted");
                return true;
            } else {
                logger.warn("User not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error deleting user", e);
            return false;
        } finally {
            session.close();
        }
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        try {
            Query<User> query = session.createQuery("from User", User.class);
            List<User> users = query.list();
            logger.info("All users retrieved successfully");
            return users;
        } catch (Exception e) {
            logger.error("Error retrieving users", e);
            return null;
        } finally {
            session.close();
        }
    }
}
