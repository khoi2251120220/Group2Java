package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Data
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingId;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private Float weight; // Khối lượng
    private String shippingMethod; // Phương thức vận chuyển

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime deliveredAt;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShippingDetail> details; // Danh sách chi tiết vận chuyển

    private String stage;
    private String description;
    private LocalDateTime timestamp;

    public enum Status {
        PENDING, IN_TRANSIT, DELIVERED
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
