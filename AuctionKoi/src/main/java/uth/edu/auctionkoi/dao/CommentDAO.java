package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(CommentDAO.class);

    public CommentDAO(String persistenceName) {
        Configuration configuration = new Configuration().configure(persistenceName);
        sessionFactory = configuration.buildSessionFactory();
    }

    public boolean addComment(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(comment);
            transaction.commit();
            logger.info("Comment successfully saved");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error adding comment", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Comment getComment(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Comment) session.get(Comment.class, id);
        } catch (Exception e) {
            logger.error("Error getting comment", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateComment(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(comment);
            transaction.commit();
            logger.info("Comment successfully updated");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error updating comment", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteComment(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Comment comment = (Comment) session.get(Comment.class, id);
            if (comment != null) {
                session.delete(comment);
                transaction.commit();
                logger.info("Comment successfully deleted");
                return true;
            } else {
                logger.warn("Comment not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error deleting comment", e);
            return false;
        } finally {
            session.close();
        }
    }
}
