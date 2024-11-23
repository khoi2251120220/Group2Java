package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.service.AddKoiService;

@Controller
@RequestMapping("/addkoi")
public class AddKoiController {
    @Autowired
    private final AddKoiService koiService;

    public AddKoiController(AddKoiService koiService) {
        this.koiService = koiService;
    }

    @GetMapping("/koi")
    public String addKoiPage(Model model) {
        model.addAttribute("koi", new Koi());
        return "interface/addkoi";
    }

    @PostMapping("/koi")
    public String saveKoi(
            @ModelAttribute Koi koi,
            @RequestParam("koiImageFile") MultipartFile koiImageFile,
            Model model) {
        try {
            if (!koiImageFile.isEmpty()) {
                String fileName = koiImageFile.getOriginalFilename();
                koi.setKoiImage(fileName);
                // TODO: Save the file to the server if necessary
            }

            koiService.saveKoi(koi);
            model.addAttribute("message", "Koi added successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "interface/addkoi";
    }

    @GetMapping("/edit/{id}")
    public String editKoiPage(@PathVariable Long id, Model model) {
        Koi koi = koiService.getKoiById(id);
        model.addAttribute("koi", koi);
        return "interface/addkoi";
    }

    @PostMapping("/edit/{id}")
    public String updateKoi(
            @PathVariable Long id,
            @ModelAttribute Koi koi,
            @RequestParam("koiImageFile") MultipartFile koiImageFile,
            Model model) {
        try {
            if (!koiImageFile.isEmpty()) {
                String fileName = koiImageFile.getOriginalFilename();
                koi.setKoiImage(fileName);
                // TODO: Save the file to the server if necessary
            }

            koiService.saveKoi(koi);
            model.addAttribute("message", "Koi updated successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "interface/addkoi";
    }

    @GetMapping("/delete/{id}")
    public String deleteKoi(@PathVariable Long id, Model model) {
        try {
            koiService.deleteKoi(id);
            model.addAttribute("message", "Koi deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }
}
