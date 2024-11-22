package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AUCTIONS")
@Data
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "koi_id")
    private Koi koi;

    @Enumerated(EnumType.STRING)
    private Method method; // Phương thức đấu giá

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long startPrice; // Giá khởi điểm
    private Long stepPrice; // Bước giá
    private Long currentBid;
    private Long participationFee;

    @Enumerated(EnumType.STRING)
    private Status status; // Trạng thái phiên đấu giá

    @OneToOne
    @JoinColumn(name = "winning_bid_id", nullable = true)
    private Bid winningBid; // Giá thắng cuộc

    public enum Method {
        FIXEDPRICE, SINGLEBID, ASCENDINGBID, DESCENDINGBID
    }

    public enum Status {
        OPEN, CLOSED, COMPLETED
    }
}

