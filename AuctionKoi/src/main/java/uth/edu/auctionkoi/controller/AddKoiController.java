package uth.edu.auctionkoi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.service.IKoiService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/addkoi")
@RequiredArgsConstructor
public class AddKoiController {

    private final IKoiService koiService;

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

                // Save the file to the server
                Path path = Paths.get("uploads/" + fileName);
                Files.createDirectories(path.getParent());
                koiImageFile.transferTo(path.toFile());
            }

            koiService.save(koi);
            model.addAttribute("save", true);
            model.addAttribute("message", "Koi added successfully!");
            model.addAttribute("koi", new Koi());
        } catch (IOException e) {
            model.addAttribute("save", false);
            model.addAttribute("errorMessage", "Error saving file: " + e.getMessage());
        } catch (Exception e) {
            model.addAttribute("save", false);
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
