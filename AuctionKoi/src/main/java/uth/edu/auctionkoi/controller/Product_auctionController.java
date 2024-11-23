package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uth.edu.auctionkoi.pojo.Product;
import uth.edu.auctionkoi.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("/product_auction")
public class Product_auctionController {

    private ProductService productService;

    @Autowired
    public void ProductAuctionController(ProductService productService) {
        this.productService = productService;
    }

    public Product_auctionController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/auction/product/id={id}")
    public String getProductAuction(@PathVariable Long id, Model model) {
        Optional<Product> productOpt = productService.findById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            System.out.println("Product found: " + productOpt.get());
        } else {
            model.addAttribute("error", "Không tìm thấy sản phẩm đấu giá.");
        }
        return "interface/product_auction";
    }
    // Xử lý yêu cầu đấu giá
    @PostMapping("/auction/placeBid")
    public String placeBid(@RequestParam("manualBid") Long manualBid,
                           @RequestParam("autoBid") Long autoBid,
                           @RequestParam("productId") Long productId,
                           Model model) {
        // Xử lý việc tăng giá đấu
        Optional<Product> productOpt = productService.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            Long currentBid = product.getCurrentBid(); // Lấy giá đấu hiện tại

            // Tính giá đấu mới
            Long newBid = (manualBid != null) ? manualBid : currentBid + autoBid;
            product.setCurrentBid(newBid); // Cập nhật giá đấu mới

            // Lưu sản phẩm cập nhật vào cơ sở dữ liệu
            productService.saveProduct(product);

            // Thêm thông tin cập nhật vào model
            model.addAttribute("product", product);
            model.addAttribute("success", "Bid placed successfully!");
        } else {
            model.addAttribute("error", "Product not found");
        }

        return "interface/product_auction"; // Trả về trang chi tiết sản phẩm với thông tin đã cập nhật
    }
}
