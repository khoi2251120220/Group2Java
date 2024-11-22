package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Tên sản phẩm
    private Long startPrice; // Giá khởi điểm
    private Long stepPrice; // Bước giá
    private Long participationFee; // Phí tham gia
    private Long deposit; // Tiền đặt cọc
    private String method; // Phương thức đấu giá
    private String location; // Địa điểm đấu giá
    private String image; // Hình ảnh sản phẩm (đường dẫn tới file ảnh)
    private String viewingTimeStart; // Thời gian bắt đầu xem tài sản
    private String viewingTimeEnd; // Thời gian kết thúc xem tài sản
    private Long currentBid; // Giá đấu hiện tại
    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getStepPrice() {
        return stepPrice;
    }

    public void setStepPrice(Long stepPrice) {
        this.stepPrice = stepPrice;
    }

    public Long getParticipationFee() {
        return participationFee;
    }

    public void setParticipationFee(Long participationFee) {
        this.participationFee = participationFee;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getViewingTimeStart() {
        return viewingTimeStart;
    }

    public void setViewingTimeStart(String viewingTimeStart) {
        this.viewingTimeStart = viewingTimeStart;
    }

    public String getViewingTimeEnd() {
        return viewingTimeEnd;
    }

    public void setViewingTimeEnd(String viewingTimeEnd) {
        this.viewingTimeEnd = viewingTimeEnd;
    }

    public Long getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Long currentBid) {
        this.currentBid = currentBid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startPrice=" + startPrice +
                ", stepPrice=" + stepPrice +
                ", participationFee=" + participationFee +
                ", deposit=" + deposit +
                ", method='" + method + '\'' +
                ", location='" + location + '\'' +
                ", image='" + image + '\'' +
                ", viewingTimeStart='" + viewingTimeStart + '\'' +
                ", viewingTimeEnd='" + viewingTimeEnd + '\'' +
                ", currentBid=" + currentBid +
                '}';
    }
}
