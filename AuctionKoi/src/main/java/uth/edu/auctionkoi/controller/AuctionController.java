package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.service.IKoiService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auctionDemo")
public class AuctionController {

    private final IKoiService koiService;

    @Autowired
    public AuctionController(IKoiService koiService) {
        this.koiService = koiService;
    }

    @GetMapping("/Koi")
    public String getKoiDetails( Model model) {
        List<Koi>  koiOpt = koiService.findAll();
        if (!koiOpt.isEmpty()) {
            System.out.println(koiOpt); // Thêm dòng này để kiểm tra
            model.addAttribute("koiList", koiOpt);
        } else {
            model.addAttribute("error", "Koi not found");
        }
        return "interface/auctionDemo";
    }
}
