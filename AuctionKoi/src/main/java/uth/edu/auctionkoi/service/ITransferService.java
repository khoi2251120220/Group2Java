package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Transfer;

import java.util.Optional;

public interface ITransferService {
    Optional<Transfer> findById(long id);
}
