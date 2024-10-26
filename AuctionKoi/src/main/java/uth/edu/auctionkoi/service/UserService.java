package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.repository.IUserRepository;
import uth.edu.auctionkoi.repository.UserRepository;

public class UserService implements IUserService {
    private IUserRepository iUserRepository = null;
    public UserService(String fileName){
        iUserRepository = new UserRepository(fileName);
    }
}
