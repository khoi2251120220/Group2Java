package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Auction;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
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
<<<<<<< HEAD

    public void deleteAuctionById(Long id) {
    }
=======
public interface AuctionService {
    public List<Auction> getAuctionsWonByUser(Long userId);
    public List<Auction> findAll();
    public Optional<Auction> findById(Long id);
    public Auction save(Auction auction);
>>>>>>> 0605bca279d0ee4d7f139209a7b803da3da12303
=======
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
}
