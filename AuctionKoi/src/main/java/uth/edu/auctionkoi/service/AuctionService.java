package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Auction;

import java.util.List;

public interface AuctionService {
    public List<Auction> getAuctionsWonByUser(Long userId);
}
