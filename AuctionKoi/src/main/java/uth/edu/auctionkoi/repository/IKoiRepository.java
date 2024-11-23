package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.pojo.Koi.Status;

import java.util.List;

@Repository
public interface IKoiRepository extends JpaRepository<Koi, Long> {
    @Query("SELECT k FROM Koi k WHERE k.status = uth.edu.auctionkoi.pojo.Koi$Status.PENDING")
    List<Koi> findAllActiveKois();
}
