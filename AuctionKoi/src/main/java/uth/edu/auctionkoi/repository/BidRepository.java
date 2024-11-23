package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
}
