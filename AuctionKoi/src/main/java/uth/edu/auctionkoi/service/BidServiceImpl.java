package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Bid;
import uth.edu.auctionkoi.repository.BidRepository;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;

    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }
}
