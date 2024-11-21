package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
