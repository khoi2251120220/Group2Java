package uth.edu.auctionkoi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.service.CloudinaryService;
import uth.edu.auctionkoi.service.IKoiService;

import java.util.Map;

@Controller
@RequestMapping("/addkoi")
@RequiredArgsConstructor
public class AddKoiController {

    private final IKoiService koiService;
    private final CloudinaryService cloudinaryService;

    @GetMapping("/koi")
    public String addKoiPage() {
        return "interface/addkoi";
    }

    @PostMapping("/koi")
    public String saveKoi(
            @ModelAttribute Koi koi,
            @RequestParam("koiImageFile") MultipartFile koiImageFile,
            Model model) {
        try {
            // Upload image to Cloudinary
            if (!koiImageFile.isEmpty()) {
                Map uploadResult = cloudinaryService.upload(koiImageFile);
                String imageUrl = (String) uploadResult.get("url"); // Get the uploaded image URL
                koi.setKoiImage(imageUrl); // Save the URL in the Koi object
            }

            // Save the Koi object to the database
            koiService.save(koi);

            model.addAttribute("save", true);
            model.addAttribute("message", "Koi added successfully!");
            model.addAttribute("koi", new Koi()); // Reset the form
        } catch (Exception e) {
            model.addAttribute("save", false);
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "interface/addkoi";
    }

    @DeleteMapping("/koi/{id}")
    public String deleteKoi(@PathVariable Long id, Model model) {
        try {
            koiService.deleteKoiById(id);
            model.addAttribute("message", "Koi deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "redirect:/addkoi/koi"; // Redirect to the koi list page
    }
}