package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.pojo.Transfer;
import uth.edu.auctionkoi.service.ITransferService;

import java.util.Optional;

@Controller
@RequestMapping("/transport")
public class TransferController {

    private final ITransferService transferService;

    @Autowired
    public TransferController(ITransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/id={id}")
    public String getTransfer(@PathVariable Long id, Model model) {
        Optional<Transfer> transferOpt = transferService.findById(id);
        if (transferOpt.isPresent()) {
            model.addAttribute("transfer", transferOpt.get());
        } else {
            model.addAttribute("error", "Transfer not found");
        }
        return "interface/transport";  // Name of the Thymeleaf view template
    }
}
