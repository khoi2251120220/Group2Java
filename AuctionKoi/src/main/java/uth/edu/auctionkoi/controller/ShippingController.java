package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.pojo.Shipping;
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
    public String getShipping(@PathVariable Long id, Model model) {
        Optional<Shipping> shippingOpt = Optional.ofNullable(shippingService.getShippingById(id));

        if (shippingOpt.isPresent()) {
            model.addAttribute("shipping", shippingOpt.get());
        } else {
            model.addAttribute("error", "Shipping not found");
        }

        return "interface/transport";
    }
}
