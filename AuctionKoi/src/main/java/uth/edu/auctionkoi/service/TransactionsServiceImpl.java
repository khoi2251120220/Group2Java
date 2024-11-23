package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Transactions;
import uth.edu.auctionkoi.repository.TransactionsRepository;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsRepository transactionsRepository;

    public Transactions saveTransaction(Transactions transaction){
        return transactionsRepository.save(transaction);
    }
}
