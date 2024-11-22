package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Auction;
import uth.edu.auctionkoi.pojo.Bid;
import uth.edu.auctionkoi.repository.AuctionRepository;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAuctionsWonByUser(Long userId) {
        return auctionRepository.findAuctionsWonByUser(userId);
    }
}
