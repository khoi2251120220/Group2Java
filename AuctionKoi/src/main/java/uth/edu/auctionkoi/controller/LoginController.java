package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.UserRepository;
import uth.edu.auctionkoi.service.PasswordEncoder;

@Controller
public class LoginController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        logger.info("Login attempt with username: {}", username);

        // Kiểm tra nếu username hoặc password bị rỗng
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Username và mật khẩu không được để trống.");
            return "redirect:/login";
        }

        try {
            // Tìm kiếm người dùng dựa trên username
            User user = userRepository.findByUsername(username);
            if (user != null) {
                // Kiểm tra mật khẩu
                if (passwordEncoder.matches(password, user.getPassword())) {
                    session.setAttribute("currentUser", user);
                    logger.info("Login successful for username: {}", username);
                    return "redirect:/";
                } else {
                    logger.warn("Invalid password for username: {}", username);
                    redirectAttributes.addFlashAttribute("error", "Mật khẩu không đúng.");
                }
            } else {
                logger.warn("User not found: {}", username);
                redirectAttributes.addFlashAttribute("error", "Tài khoản không tồn tại.");
            }
        } catch (Exception e) {
            logger.error("An error occurred during login for username: {}", username, e);
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi đăng nhập. Vui lòng thử lại.");
        }

        return "redirect:/login"; // Quay lại trang đăng nhập
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        logger.info("User logged out");
        session.invalidate(); // Xóa tất cả session
        return "redirect:/";
    }
}
