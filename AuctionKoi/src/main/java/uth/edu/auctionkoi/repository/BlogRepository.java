package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.auctionkoi.pojo.Blog; // Updated package

public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Additional query methods if needed
}