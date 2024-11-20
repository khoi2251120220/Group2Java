package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Product;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);
    void saveProduct(Product product);
}
