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
        Configuration config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addBlog(Blog blog) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(blog);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding blog", e);
            return false;
        }
    }

    public Blog getBlog(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Blog.class, id);
        } catch (Exception e) {
            logger.error("Error getting blog", e);
            return null;
        }
    }

    public boolean updateBlog(Blog blog) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(blog);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating blog", e);
            return false;
        }
    }

    public boolean deleteBlog(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Blog blog = session.get(Blog.class, id);
            if (blog != null) {
                session.delete(blog);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error deleting blog", e);
            return false;
        }
    }
}
