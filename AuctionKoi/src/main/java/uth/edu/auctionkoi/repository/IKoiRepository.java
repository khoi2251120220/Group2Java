package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.auctionkoi.pojo.Koi;

public interface IKoiRepository extends JpaRepository<Koi, Long> {
}
