//package uth.edu.auctionkoi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import uth.edu.auctionkoi.pojo.Koi;
//import uth.edu.auctionkoi.service.KoiService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/admin/kois")
//public class KoiManagementController {
//
//    @Autowired
//    private KoiService koiService;
//
//    // Hiển thị danh sách cá Koi (có thể lọc theo trạng thái)
//    @GetMapping
//    public String listKois(@RequestParam(value = "status", required = false) Koi.Status status, Model model) {
//        List<Koi> kois;
//        if (status != null) {
//            kois = koiService.findByStatus(status); // Lọc theo trạng thái
//        } else {
//            kois = koiService.findAll(); // Lấy toàn bộ cá Koi
//        }
//        model.addAttribute("kois", kois);
//        model.addAttribute("statuses", Koi.Status.values()); // Truyền danh sách trạng thái
//        return "koi-management"; // File HTML hiển thị danh sách cá
//    }
//
//    // Duyệt cá Koi để đưa vào đấu giá
//    @PostMapping("/approve")
//    public String approveKois(@RequestParam List<Long> koiIds) {
//        for (Long id : koiIds) {
//            Optional<Koi> koiOptional = koiService.findById(id);
//            koiOptional.ifPresent(koi -> {
//                koi.setStatus(Koi.Status.AUCTIONED); // Cập nhật trạng thái
//                koiService.save(koi); // Lưu thay đổi
//            });
//        }
//        return "redirect:/admin/kois";
//    }
//
//    // Đánh dấu cá là đã bán
//    @PostMapping("/sold")
//    public String markAsSold(@RequestParam List<Long> koiIds) {
//        for (Long id : koiIds) {
//            Optional<Koi> koiOptional = koiService.findById(id);
//            koiOptional.ifPresent(koi -> {
//                koi.setStatus(Koi.Status.SOLD); // Cập nhật trạng thái
//                koiService.save(koi); // Lưu thay đổi
//            });
//        }
//        return "redirect:/admin/kois";
//    }
//
//    // Xóa cá Koi
//    @PostMapping("/delete")
//    public String deleteKoi(@RequestParam Long koiId) {
//        koiService.deleteKoiById(koiId);
//        return "redirect:/admin/kois";
//    }
//}
