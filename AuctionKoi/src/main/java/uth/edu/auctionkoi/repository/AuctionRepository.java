package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import uth.edu.auctionkoi.pojo.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    // Additional query methods if needed
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Auction;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query("SELECT a FROM Auction a WHERE a.winningBid.user.id = :userId")
    List<Auction> findAuctionsWonByUser(@Param("userId") Long userId);
>>>>>>> 386c01ae18a85d0ae7a4959c7cfdcfe0694262c7
}
