package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Koi;

import java.util.List;
import java.util.Optional;

public interface IKoiService {
    Optional<Koi> findById(Long id);

    List<Koi> findAll();  // Thêm phương thức mới

    Koi save(Koi koi);

    void deleteKoi(Long id);
}