package uth.edu.auctionkoi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.IUserRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final IUserRepository iUserRepository;

    @Override
    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    public int getUserCount() {
        return iUserRepository.findAll().size();
    }

    public void deleteUserById(Long id) {
    }
}
