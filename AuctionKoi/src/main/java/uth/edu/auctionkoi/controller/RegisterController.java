package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.repository.UserRepository;
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
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        try {
            // Kiểm tra xem email đã tồn tại
            if (userRepository.existsByEmail(email)) {
                redirectAttributes.addFlashAttribute("error", "Email đã tồn tại.");
                redirectAttributes.addFlashAttribute("username", username);
                redirectAttributes.addFlashAttribute("fullName", fullName);
                redirectAttributes.addFlashAttribute("phoneNumber", phoneNumber);
                return "redirect:/register";
            }

            // Kiểm tra số điện thoại hợp lệ (bắt đầu bằng số 0)
            if (!phoneNumber.startsWith("0")) {
                redirectAttributes.addFlashAttribute("error", "Số điện thoại không hợp lệ. Phải bắt đầu bằng số 0.");
                redirectAttributes.addFlashAttribute("username", username);
                redirectAttributes.addFlashAttribute("fullName", fullName);
                redirectAttributes.addFlashAttribute("email", email);
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

            // Chuyển hướng đến trang đăng nhập
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi. Vui lòng thử lại.");
            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("fullName", fullName);
            redirectAttributes.addFlashAttribute("phoneNumber", phoneNumber);
            redirectAttributes.addFlashAttribute("email", email);
            return "redirect:/register";
        }
    }
}
