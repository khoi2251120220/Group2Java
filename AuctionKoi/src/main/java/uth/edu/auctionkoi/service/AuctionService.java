package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Auction;
import uth.edu.auctionkoi.repository.AuctionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Optional<Auction> getAuctionById(Long id) {
        return auctionRepository.findById(id);
    }

    public Auction saveAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }

    public int getActiveAuctionsCount() {
        return (int) auctionRepository.findAll().stream()
                .filter(auction -> auction.getStatus() == Auction.Status.OPEN)
                .count();
    }
}
