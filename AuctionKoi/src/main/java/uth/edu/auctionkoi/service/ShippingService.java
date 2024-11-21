package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.Shipping;
import uth.edu.auctionkoi.pojo.ShippingDetail;

import java.util.List;

public interface ShippingService {
    public List<Shipping> getAllShippings();
    public Shipping getShippingById(Long id);
    public Shipping createShipping(Shipping shipping);
    public boolean deleteShipping(Long id);
    public ShippingDetail addShippingDetail(Long shippingId, String stage, String description, ShippingDetail.Status status);


}
