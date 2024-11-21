package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, 
                       @RequestParam String password, 
                       HttpSession session) {
        try {
            User user = userRepository.findByUsernameAndPassword(username, password);
            
            if (user != null) {
                session.setAttribute("currentUser", user);
                return "redirect:/home";
            }
            
            return "redirect:/home";
            
        } catch (Exception e) {
            return "redirect:/home";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("currentUser");
        return "redirect:/home";
    }
}
