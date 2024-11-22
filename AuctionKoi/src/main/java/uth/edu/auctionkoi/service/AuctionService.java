package uth.edu.auctionkoi.service;

<<<<<<< HEAD
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
=======
import uth.edu.auctionkoi.pojo.Auction;

import java.util.List;

public interface AuctionService {
    public List<Auction> getAuctionsWonByUser(Long userId);
>>>>>>> 386c01ae18a85d0ae7a4959c7cfdcfe0694262c7
}
