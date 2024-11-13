package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uth.edu.auctionkoi.pojo.Koi;

@Repository
public interface IKoiRepository extends JpaRepository<Koi, Long> {
    // Không cần thêm phương thức nào vì JpaRepository đã cung cấp các phương thức cơ bản
}
