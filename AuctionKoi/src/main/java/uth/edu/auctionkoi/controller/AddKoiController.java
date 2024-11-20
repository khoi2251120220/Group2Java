package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.service.IKoiService;

@Controller
@RequestMapping("/addkoi")
public class AddKoiController {
    @Autowired
    private final IKoiService koiService;

    public AddKoiController(IKoiService koiService) {
        this.koiService = koiService;
    }

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
            // Handle image file upload
            if (!koiImageFile.isEmpty()) {
                String fileName = koiImageFile.getOriginalFilename();
                koi.setKoiImage(fileName); // Set the image filename in the Koi object
                // TODO: Save the file to the server if necessary
            }

            koiService.save(koi); // Save the koi object to the database
            model.addAttribute("save", true); // Add success flag to the model
            model.addAttribute("koi", new Koi()); // Reset the form

            // Add a success message
            model.addAttribute("message", "Koi added successfully!");

        } catch (Exception e) {
            model.addAttribute("save", false); // Add failure flag to the model
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "interface/addkoi"; // Return the view template
    }

}
