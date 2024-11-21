package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.pojo.User;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String index() {
        return "index";
    }

    @GetMapping("/transport")
    public String shipping(Model model) {
        return "interface/transport";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        // Kiểm tra session
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            model.addAttribute("currentUser", currentUser);
            System.out.println("Current user in session: " + currentUser.getUsername());
        }
        return "home";
    }
}
