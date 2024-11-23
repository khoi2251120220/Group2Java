package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Auction;
import java.util.List;
import java.util.Optional;

public interface AuctionService {
    void save(Auction auction);
    Optional<Auction> findById(Long id);
    List<Auction> getAllAuctions();
    int getActiveAuctionsCount();
    void deleteAuctionById(Long id);
    List<Auction> getAuctionsWonByUser(Long userId);
}
