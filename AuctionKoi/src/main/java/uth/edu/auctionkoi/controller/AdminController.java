package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uth.edu.auctionkoi.service.UserService;
import uth.edu.auctionkoi.service.KoiService;
import uth.edu.auctionkoi.service.AuctionService;
import uth.edu.auctionkoi.service.BlogService;

@Controller
public class AdminController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private KoiService koiService;
//
//    @Autowired
//    private AuctionService auctionService;
//
//    @Autowired
//    private BlogService blogService;

    @GetMapping("/admin")
    public String dashboard(Model model) {
//        int userCount = userService.getUserCount();
//        int koiCount = koiService.getKoiCount();
//        int activeAuctionsCount = auctionService.getActiveAuctionsCount();
//        int blogCount = blogService.getBlogCount();
//
//        model.addAttribute("userCount", userCount);
//        model.addAttribute("koiCount", koiCount);
//        model.addAttribute("activeAuctionsCount", activeAuctionsCount);
//        model.addAttribute("blogCount", blogCount);
//
//        model.addAttribute("users", userService.getAllUsers());
//        model.addAttribute("kois", koiService.getAllKoi());
//        model.addAttribute("auctions", auctionService.getAllAuctions());
//        model.addAttribute("blogs", blogService.getAllBlogs());

        return "dashboard";
    }
<<<<<<< HEAD
<<<<<<< HEAD

    @PostMapping("/admin/users/delete")
    @ResponseBody
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "success";
    }

    @PostMapping("/admin/koi/delete")
    @ResponseBody
    public String deleteKoi(@RequestParam("id") Long id) {
        koiService.deleteKoiById(id);
        return "success";
    }

    @PostMapping("/admin/auctions/delete")
    @ResponseBody
    public String deleteAuction(@RequestParam("id") Long id) {
        auctionService.deleteAuctionById(id);
        return "success";
    }

    @PostMapping("/admin/blogs/delete")
    @ResponseBody
    public String deleteBlog(@RequestParam("id") Long id) {
        blogService.deleteBlogById(id);
        return "success";
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("kois", addKoiService.getAllActiveKois());
        model.addAttribute("auctions", auctionService.getAllAuctions());
        // Add other attributes as needed
        return "dashboard";
    }
=======
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
}
=======
}
>>>>>>> 0605bca279d0ee4d7f139209a7b803da3da12303
