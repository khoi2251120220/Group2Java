package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.auctionkoi.pojo.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
