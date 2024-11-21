package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username,
                                    @RequestParam String fullName,
                                    @RequestParam String phoneNumber,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    HttpSession session) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setFullName(fullName);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setPassword(password);

            userRepository.save(user);
            
            session.setAttribute("currentUser", user);
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}