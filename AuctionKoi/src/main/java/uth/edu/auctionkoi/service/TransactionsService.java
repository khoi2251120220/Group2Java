package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Transactions;

import java.util.List;

public interface TransactionsService {
    public Transactions saveTransaction(Transactions transaction);
    public List<Transactions> findByUserId(Long userId);
    public Transactions findById(Long id);
}
