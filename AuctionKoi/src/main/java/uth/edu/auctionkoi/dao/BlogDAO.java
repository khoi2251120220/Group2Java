package uth.edu.auctionkoi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(BlogDAO.class);

    public BlogDAO(String persistenceName) {
        Configuration configuration = new Configuration().configure(persistenceName);
        sessionFactory = configuration.buildSessionFactory();
    }

    public boolean addBlog(Blog blog) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(blog);
            transaction.commit();
            logger.info("Blog successfully saved");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error adding blog", e);
            return false;
        } finally {
            session.close();
        }
    }

    public Blog getBlog(long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Blog) session.get(Blog.class, id);
        } catch (Exception e) {
            logger.error("Error getting blog", e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateBlog(Blog blog) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(blog);
            transaction.commit();
            logger.info("Blog successfully updated");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error updating blog", e);
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteBlog(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Blog blog = (Blog) session.get(Blog.class, id);
            if (blog != null) {
                session.delete(blog);
                transaction.commit();
                logger.info("Blog successfully deleted");
                return true;
            } else {
                logger.warn("Blog not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Error deleting blog", e);
            return false;
        } finally {
            session.close();
        }
    }
}
