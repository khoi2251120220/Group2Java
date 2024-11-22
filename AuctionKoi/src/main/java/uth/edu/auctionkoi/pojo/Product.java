package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Data
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
    //private String location; // Địa điểm đấu giá
    //private String image; // Hình ảnh sản phẩm (đường dẫn tới file ảnh)
    private String viewingTimeStart; // Thời gian bắt đầu xem tài sản
    private String viewingTimeEnd; // Thời gian kết thúc xem tài sản
    private Long currentBid; // Giá đấu hiện tại

    @OneToOne
    @JoinColumn(name = "koi_id")
    private Koi koi;
}
