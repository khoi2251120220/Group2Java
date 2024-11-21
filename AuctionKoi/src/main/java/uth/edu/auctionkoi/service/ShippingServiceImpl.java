package uth.edu.auctionkoi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uth.edu.auctionkoi.pojo.Shipping;
import uth.edu.auctionkoi.pojo.ShippingDetail;
import uth.edu.auctionkoi.repository.ShippingDetailRepository;
import uth.edu.auctionkoi.repository.ShippingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ShippingDetailRepository shippingDetailRepository;

    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }

    public Shipping getShippingById(Long id) {
        return shippingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping not found"));
    }

    public Shipping createShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public boolean deleteShipping(Long id) {
        if (shippingRepository.existsById(id)) {
            shippingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ShippingDetail addShippingDetail(Long shippingId, String stage, String description, ShippingDetail.Status status) {
        Shipping shipping = getShippingById(shippingId);

        ShippingDetail detail = new ShippingDetail();
        detail.setShipping(shipping);
        detail.setStage(stage);
        detail.setDescription(description);
        detail.setTimestamp(java.time.LocalDateTime.now());
        detail.setStatus(status);

        return shippingDetailRepository.save(detail);
    }
}
