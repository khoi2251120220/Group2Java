package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.service.IUserService;
import uth.edu.auctionkoi.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private final IUserService userService;

    public TestController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String test(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "test";
    }
}
