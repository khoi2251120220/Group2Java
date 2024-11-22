package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uth.edu.auctionkoi.pojo.Transactions;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.service.AuctionService;
import uth.edu.auctionkoi.service.TransactionsService;


@Controller
public class PaymentController {

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/payment")
    public String showPaymentPage(Model model, HttpSession session) {
        // Kiểm tra trạng thái đăng nhập
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            model.addAttribute("error", "Bạn cần đăng nhập để truy cập chức năng này.");
            return "redirect:/login";
        }

        model.addAttribute("auctions", auctionService.getAuctionsWonByUser(currentUser.getId()));
        return "interface/payment";
    }


}
