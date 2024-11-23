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

//    @GetMapping("/transport")
//    public String shipping(Model model) {
//        return "interface/transport";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        return "modal/login";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "interface/about";
    }



    @GetMapping("/account")
    public String account(Model model) {
        return "interface/account";
    }

    @GetMapping("/addkoi")
    public String addkoi(Model model) {
        return "interface/addkoi";
    }

//    @GetMapping("/auction")
//    public String auction(Model model) {
//        return "interface/auction";
//    }

    @GetMapping("/auctionDemo")
    public String auctionDemo(Model model) {
        return "interface/auctionDemo";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        return "interface/blog";
    }

//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//        return "interface/dashboard";
//    }

    @GetMapping("/notification")
    public String notification(Model model) {
        return "interface/notification";
    }

    @GetMapping("/Ogon")
    public String Ogon(Model model) {
        return "interface/Ogon";
    }

//    @GetMapping("/payment")
//    public String payment(Model model) {
//        return "interface/payment";
//    }

    @GetMapping("/product_auction")
    public String product(Model model) {
        return "interface/product_auction";
    }

    @GetMapping("/setting")
    public String setting(Model model) {
        return "interface/setting";
    }
//   @GetMapping("/transport")
//    public String transport(Model model) {
//        return "interface/transport";
//    }

    @GetMapping("/register")
    public String register(Model model) {
        return "modal/register";
    }



//    @GetMapping("/home")
//    public String home(Model model, HttpSession session) {
//        // Kiểm tra session
//        User currentUser = (User) session.getAttribute("currentUser");
//        if (currentUser != null) {
//            model.addAttribute("currentUser", currentUser);
//            System.out.println("Current user in session: " + currentUser.getUsername());
//        }
//        return "home";
//    }
}
