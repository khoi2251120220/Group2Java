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

    @Override
    public void save(Auction auction) {
        auctionRepository.save(auction);
    }

    @Override
    public Optional<Auction> findById(Long id) {
        return auctionRepository.findById(id);
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public int getActiveAuctionsCount() {
        return (int) auctionRepository.findAll().stream()
                .filter(auction -> auction.getStatus() == Auction.Status.OPEN)
                .count();
    }

    @Override
    public void deleteAuctionById(Long id) {
        auctionRepository.deleteById(id);
    }

    @Override
    public List<Auction> getAuctionsWonByUser(Long userId) {
        return auctionRepository.findAuctionsWonByUser(userId);
    }
}
