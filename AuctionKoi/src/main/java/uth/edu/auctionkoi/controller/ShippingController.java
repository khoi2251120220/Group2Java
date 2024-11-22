package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.pojo.Shipping;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.service.ShippingService;

import java.util.Optional;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/id={id}")
    public String getShipping(@PathVariable Long id, Model model, HttpSession session) {
        // Kiểm tra trạng thái đăng nhập
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            model.addAttribute("error", "Bạn cần đăng nhập để truy cập chức năng này.");
            return "redirect:/login";
        }

        // Lấy thông tin Shipping
        Shipping shipping = shippingService.getShippingById(id);
        if (shipping == null) {
            model.addAttribute("error", "Không tìm thấy thông tin vận chuyển.");
            return "fragments/error-message";
        }

        // Kiểm tra quyền truy cập
        if (!shipping.getSender().getId().equals(currentUser.getId()) &&
                !shipping.getReceiver().getId().equals(currentUser.getId())) {
            model.addAttribute("error", "Bạn không có quyền truy cập vào thông tin vận chuyển này.");
            return "fragments/error-message";
        }

        // Đưa dữ liệu vào model
        model.addAttribute("shipping", shipping);

        return "interface/transport";
    }

}
