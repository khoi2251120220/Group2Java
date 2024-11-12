package uth.edu.auctionkoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("title", "Dashboard");
        model.addAttribute("userCount", 150);
        model.addAttribute("postCount", 75);
        model.addAttribute("commentCount", 300);
        return "interface/dashboard";
    }
}

