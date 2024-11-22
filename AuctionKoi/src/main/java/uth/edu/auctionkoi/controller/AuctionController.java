package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.pojo.Product;
import uth.edu.auctionkoi.service.IKoiService;
import uth.edu.auctionkoi.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auctionDemo")
public class AuctionController {

    @Autowired
    private final ProductService productService;

    @Autowired
    public AuctionController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/Koi")
    public String getKoiDetails( Model model) {
        List<Product>  products = productService.findAll();
        products.get(0).getKoi().getKoiType();
        if (!products.isEmpty()) {
            System.out.println(products); // Thêm dòng này để kiểm tra
            model.addAttribute("products", products);
        } else {
            model.addAttribute("error", "Koi not found");
        }
            return "interface/auctionDemo";
    }
}
