package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.repository.IAddKoiRepository;
import java.util.List;

@Service
public class AddKoiService {
    @Autowired
    private IAddKoiRepository addKoiRepository;

    public List<Koi> getAllActiveKois() {
        return addKoiRepository.findAllActiveKois();
    }

    public void saveKoi(Koi koi) {
        addKoiRepository.save(koi);
    }

    public Koi getKoiById(Long id) {
        return addKoiRepository.findById(id).orElse(null);
    }

    public void deleteKoi(Long id) {
        addKoiRepository.deleteById(id);
    }
}
