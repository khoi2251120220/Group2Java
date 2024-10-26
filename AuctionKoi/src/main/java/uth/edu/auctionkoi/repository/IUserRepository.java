package uth.edu.auctionkoi.repository;

import uth.edu.auctionkoi.pojo.User;

import java.util.List;

public interface IUserRepository {
    public boolean addUser(User user);
    public User findUserByUsername(String username);
    public User findUserByEmail(String email);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
    public List<User> findAllUsers();
}
