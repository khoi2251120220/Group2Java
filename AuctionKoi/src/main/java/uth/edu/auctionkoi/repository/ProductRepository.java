package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.auctionkoi.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}
