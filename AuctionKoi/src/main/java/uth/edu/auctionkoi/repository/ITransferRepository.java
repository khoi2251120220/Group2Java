package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.auctionkoi.pojo.Transfer;

public interface ITransferRepository extends JpaRepository<Transfer, Long> {
}
