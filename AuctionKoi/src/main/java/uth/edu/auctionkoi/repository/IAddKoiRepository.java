package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uth.edu.auctionkoi.pojo.Koi;
import java.util.List;

public interface IAddKoiRepository extends JpaRepository<Koi, Long> {
    @Query("SELECT k FROM Koi k WHERE k.isDeleted = false OR k.isDeleted IS NULL")
    List<Koi> findAllActiveKois();
}
