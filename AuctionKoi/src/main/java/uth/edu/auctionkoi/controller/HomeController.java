package uth.edu.auctionkoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
