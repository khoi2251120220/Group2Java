package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
public class ShippingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    @ManyToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping; // Liên kết với lô hàng chính

    @Column(columnDefinition = "NVARCHAR(255)")
    private String stage; // Mô tả giai đoạn (VD: "Đang vận chuyển đến công ty")
    @Column(columnDefinition = "NVARCHAR(500)")
    private String description; // Chi tiết bổ sung về giai đoạn

    private LocalDateTime timestamp; // Thời gian cập nhật giai đoạn

    @Enumerated(EnumType.STRING)
    private Status status; // Trạng thái giai đoạn

    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }
}
