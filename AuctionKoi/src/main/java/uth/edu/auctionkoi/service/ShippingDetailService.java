package uth.edu.auctionkoi.service;

import uth.edu.auctionkoi.pojo.ShippingDetail;

import java.util.List;

public interface ShippingDetailService {
    public List<ShippingDetail> getAllShippingDetails();
    public ShippingDetail getShippingDetailById(Long id);
    public ShippingDetail createShippingDetail(ShippingDetail detail);
    public boolean deleteShippingDetail(Long id);
}
