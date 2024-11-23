package uth.edu.auctionkoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Koi;
import uth.edu.auctionkoi.repository.IAddKoiRepository;

@Service
public class AddKoiService {
    @Autowired
    private static IAddKoiRepository addKoiRepository;

    public static void saveKoi(Koi koi) {
        addKoiRepository.save(koi);
    }
}
