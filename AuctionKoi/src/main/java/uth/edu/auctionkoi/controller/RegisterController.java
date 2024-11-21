package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.UserRepository;
import org.springframework.stereotype.Controller;
import uth.edu.auctionkoi.service.PasswordEncoder;

@Controller
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String fullName,
            @RequestParam String phoneNumber,
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {
        try {
            // Kiểm tra xem email hoặc username đã tồn tại chưa
            if (userRepository.existsByEmail(email) || userRepository.existsByUsername(username)) {
                return "redirect:/register";
            }

            // Tạo người dùng mới
            User user = new User();
            user.setUsername(username);
            user.setFullName(fullName);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));

            // Lưu vào database
            userRepository.save(user);

            // Lưu thông tin người dùng vào session nếu cần
            session.setAttribute("currentUser", user);

            // Trả về phản hồi thành công
            return "redirect:/login";
        } catch (Exception e) {
           return "redirect:/register";
        }
    }
}