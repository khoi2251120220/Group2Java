package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.repository.IKoiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KoiService implements IKoiService {

    private final IKoiRepository koiRepository;

    @Autowired
    public KoiService(IKoiRepository koiRepository) {
        this.koiRepository = koiRepository;
    }

    @Override
    public Optional<Koi> findById(Long id) {
        return koiRepository.findById(id);
    }

    @Override
    public List<Koi> findAll() {
        return koiRepository.findAll();  // Trả về danh sách tất cả Koi
    }

    @Override
    public Koi save(Koi koi) {
        return koiRepository.save(koi);
    }
<<<<<<< HEAD

    public int getKoiCount() {
        return koiRepository.findAll().size();
    }

    public List<Koi> getAllKoi() {
        return koiRepository.findAll();
    }
<<<<<<< HEAD

    public void deleteKoiById(Long id) {
    }

    public List<Koi> getAllActiveKois() {
        return koiRepository.findAllActiveKois();
    }
=======
>>>>>>> 0605bca279d0ee4d7f139209a7b803da3da12303
=======
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
}