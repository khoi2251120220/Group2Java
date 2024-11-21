package uth.edu.auctionkoi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.ShippingDetail;
import uth.edu.auctionkoi.repository.ShippingDetailRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingDetailServiceImpl implements ShippingDetailService {
    @Autowired
    private ShippingDetailRepository shippingDetailRepository;

    public List<ShippingDetail> getAllShippingDetails() {
        return shippingDetailRepository.findAll();
    }

    public ShippingDetail getShippingDetailById(Long id) {
        return shippingDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShippingDetail not found"));
    }

    public ShippingDetail createShippingDetail(ShippingDetail detail) {
        return shippingDetailRepository.save(detail);
    }

    public boolean deleteShippingDetail(Long id) {
        if (shippingDetailRepository.existsById(id)) {
            shippingDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
