package uth.edu.auctionkoi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.service.AddKoiService;

import uth.edu.auctionkoi.service.CloudinaryService;
import uth.edu.auctionkoi.service.IKoiService;


import java.util.Map;
import uth.edu.auctionkoi.service.IKoiService;

@Controller
@RequestMapping("/addkoi")
@RequiredArgsConstructor
public class AddKoiController {
    @Autowired
    private final IKoiService koiService;

    public AddKoiController(IKoiService koiService) {
        this.koiService = koiService;
    }

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
            model.addAttribute("save", false); // Add failure flag to the model
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "interface/addkoi"; // Return the view template
    }
<<<<<<< HEAD

<<<<<<< HEAD
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
=======
>>>>>>> 0605bca279d0ee4d7f139209a7b803da3da12303
=======
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
}
