package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Account and password are required.");
            return "login"; // Trả về trang login nếu có lỗi
        }

        User user = userRepository.findByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            // Đăng nhập thành công
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}
