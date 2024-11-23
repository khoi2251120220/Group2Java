package uth.edu.auctionkoi.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uth.edu.auctionkoi.pojo.Auction;
import uth.edu.auctionkoi.pojo.Bid;
import uth.edu.auctionkoi.pojo.User;
import uth.edu.auctionkoi.service.AuctionService;
import uth.edu.auctionkoi.service.BidService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private final AuctionService auctionService;

    @Autowired
    private final BidService bidService;

    public AuctionController(AuctionService auctionService, BidService bidService) {
        this.auctionService = auctionService;
        this.bidService = bidService;
    }


    @GetMapping
    public String getAuctionPage( Model model) {
        List<Auction>  auctionList = auctionService.findAll();
        if (!auctionList.isEmpty()) {
            model.addAttribute("auctions", auctionList);
        } else {
            model.addAttribute("error", "Koi not found");
        }
            return "interface/auctionDemo";
    }

    @GetMapping("/id={id}")
    public String getProductAuction(@PathVariable Long id, Model model) {
        Optional<Auction> auction = auctionService.findById(id);
        if (auction.isPresent()) {
            model.addAttribute("auction", auction.get());
            System.out.println("Auction found: " + auction.get());
        } else {
            model.addAttribute("error", "Không tìm thấy sản phẩm đấu giá.");
        }
        return "interface/product_auction";
    }

    // Xử lý yêu cầu đấu giá
    @PostMapping("/bid")
    public String placeBid(@RequestParam("manualBid") Long manualBid,
                           @RequestParam("autoBid") Long autoBid,
                           @RequestParam("auctionId") Long auctionId,
                           Model model,
                           HttpSession session) {
        // Kiểm tra trạng thái đăng nhập
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            model.addAttribute("error", "Bạn cần đăng nhập để truy cập chức năng này.");
            return "redirect:/login";
        }
        // Xử lý việc tăng giá đấu
        Optional<Auction> auctionOpt = auctionService.findById(auctionId);
        if (auctionOpt.isPresent()) {
            Auction auction = auctionOpt.get();
            Long currentBid = auction.getCurrentPrice(); // Lấy giá đấu hiện tại

            if(manualBid > currentBid) {
                Bid bid = new Bid();
                bid.setAuction(auction);
                bid.setBidAmount(BigDecimal.valueOf(manualBid));
                bid.setUser(currentUser);
                bid.setBidTime(LocalDateTime.now());
                bidService.save(bid);

                auction.setCurrentPrice(manualBid);// Cập nhật giá đấu mới
                // Lưu sản phẩm cập nhật vào cơ sở dữ liệu
                auctionService.save(auction);
            }

            // Thêm thông tin cập nhật vào model
            model.addAttribute("auction", auction);
            model.addAttribute("success", "Bid placed successfully!");
        } else {
            model.addAttribute("error", "Product not found");
        }

        return "interface/product_auction"; // Trả về trang chi tiết sản phẩm với thông tin đã cập nhật
    }
}
