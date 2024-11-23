package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Auction;
import uth.edu.auctionkoi.repository.AuctionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAuctionsWonByUser(Long userId) {
        return auctionRepository.findAuctionsWonByUser(userId);
    }
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Optional<Auction> findById(Long id) {
        return auctionRepository.findById(id);
    }

    public Auction save(Auction auction) {
        return auctionRepository.save(auction);
    }
}
