package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Blog;
import uth.edu.auctionkoi.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }
<<<<<<< HEAD

    public int getBlogCount() {
        return blogRepository.findAll().size();
    }
<<<<<<< HEAD

    public void deleteBlogById(Long id) {
    }
=======
>>>>>>> 0605bca279d0ee4d7f139209a7b803da3da12303
=======
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
}
