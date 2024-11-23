package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Auction;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query("SELECT a FROM Auction a WHERE a.winningBid.user.id = :userId")
    List<Auction> findAuctionsWonByUser(@Param("userId") Long userId);

    Optional<Auction> findById(Long id);
}
