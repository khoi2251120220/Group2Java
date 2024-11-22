//package uth.edu.auctionkoi.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import uth.edu.auctionkoi.pojo.Staff;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class StaffDAO {
//    private final SessionFactory sessionFactory;
//    private static final Logger logger = LoggerFactory.getLogger(StaffDAO.class);
//
//    public StaffDAO(String persistenceName) {
//        Configuration config = new Configuration().configure(persistenceName);
//        sessionFactory = config.buildSessionFactory();
//    }
//
//    public boolean addStaff(Staff staff) {
//        Transaction transaction = null;
//        Session session = sessionFactory.openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.save(staff);
//            transaction.commit();
//            logger.info("Staff successfully added");
//            return true;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            logger.error("Error adding staff", e);
//            return false;
//        } finally {
//            session.close();
//        }
//    }
//
//    public Staff getStaff(long id) {
//        Session session = sessionFactory.openSession();
//        try {
//            return (Staff) session.get(Staff.class, id);
//        } catch (Exception e) {
//            logger.error("Error getting staff", e);
//            return null;
//        } finally {
//            session.close();
//        }
//    }
//
//    public boolean updateStaff(Staff staff) {
//        Transaction transaction = null;
//        Session session = sessionFactory.openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.update(staff);
//            transaction.commit();
//            logger.info("Staff successfully updated");
//            return true;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            logger.error("Error updating staff", e);
//            return false;
//        } finally {
//            session.close();
//        }
//    }
//
//    public boolean deleteStaff(long id) {
//        Transaction transaction = null;
//        Session session = sessionFactory.openSession();
//        try {
//            transaction = session.beginTransaction();
//            Staff staff = (Staff) session.get(Staff.class, id);
//            if (staff != null) {
//                session.delete(staff);
//                transaction.commit();
//                logger.info("Staff successfully deleted");
//                return true;
//            } else {
//                logger.warn("Staff not found with ID: " + id);
//                return false;
//            }
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            logger.error("Error deleting staff", e);
//            return false;
//        } finally {
//            session.close();
//        }
//    }
//}
