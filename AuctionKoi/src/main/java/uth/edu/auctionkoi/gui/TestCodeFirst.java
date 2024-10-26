package uth.edu.auctionkoi.gui;

import uth.edu.auctionkoi.service.IUserService;
import uth.edu.auctionkoi.service.UserService;

public class TestCodeFirst {
    public static void main(String[] args) {
        String fileName = "hibernate.cfg.xml";
        IUserService userService = new UserService(fileName);
    }
}
