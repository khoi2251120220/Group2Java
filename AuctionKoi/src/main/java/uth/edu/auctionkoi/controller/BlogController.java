package uth.edu.auctionkoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uth.edu.auctionkoi.pojo.Blog;
import uth.edu.auctionkoi.service.BlogService;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String getBlogs(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        System.out.println("Blogs: " + blogs); // Log dữ liệu blogs
        model.addAttribute("blogs", blogs);  // Gắn danh sách blogs vào model
        return "interface/blog";  // Đường dẫn tới file blog.html
    }

    @GetMapping("/blog/{id}")
    public String viewBlogDetail(@PathVariable Long id, Model model) {
        Optional<Blog> blog = blogService.getBlogById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "interface/blog-detail"; // Đường dẫn tới file blog-detail.html
        }
        return "error/404"; // Đường dẫn tới trang 404 nếu không tìm thấy blog
    }
}
