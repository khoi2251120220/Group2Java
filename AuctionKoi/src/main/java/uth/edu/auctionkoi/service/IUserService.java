package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    void saveUser(User user);
    void deleteUserById(Long id);
}
