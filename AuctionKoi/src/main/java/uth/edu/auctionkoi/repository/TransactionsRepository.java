package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
