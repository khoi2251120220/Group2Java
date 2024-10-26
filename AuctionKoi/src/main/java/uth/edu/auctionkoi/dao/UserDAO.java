package uth.edu.auctionkoi.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import uth.edu.auctionkoi.pojo.User;

public class UserDAO {
    private SessionFactory sessionFactory = null;
    private Configuration config = null;

    public UserDAO(String persistenceName) {
        config = new Configuration().configure(persistenceName);
        sessionFactory = config.buildSessionFactory();
    }

    public boolean addUser(User user) {return false;};
    public User getUser(int id) { return null; };
    public boolean updateUser(User user) {return user != null;};
    public User getUserByEmail(String email) { return null; }
    public boolean deleteUser(int id) {return false;};
    public boolean deleteUserByEmail(String email) {return false;};
}
