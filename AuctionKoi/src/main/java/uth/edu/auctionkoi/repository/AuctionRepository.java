package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.auctionkoi.pojo.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    // Additional query methods if needed
}
