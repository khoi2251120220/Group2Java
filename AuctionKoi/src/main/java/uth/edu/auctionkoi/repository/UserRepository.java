package uth.edu.auctionkoi.repository;

import uth.edu.auctionkoi.dao.UserDAO;
import uth.edu.auctionkoi.pojo.User;

import java.util.List;

public class UserRepository implements IUserRepository {
    private UserDAO userDAO = null;

    public UserRepository(String fileConfig) {
        userDAO = new UserDAO(fileConfig);
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }
}
