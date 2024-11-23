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
<<<<<<< HEAD
    @Column(name = "id")
    private Long id;
<<<<<<< HEAD
    @OneToOne(cascade = CascadeType.REMOVE)
=======
    private Long auctionId;
    @OneToOne
>>>>>>> 0605bca279d0ee4d7f139209a7b803da3da12303
=======
    @OneToOne
>>>>>>> parent of 2b58706 (up thêm xóa Koi)
    @JoinColumn(name = "koi_id")
    private Koi koi;

    @Enumerated(EnumType.STRING)
    private Method method; // Phương thức đấu giá

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long startPrice; // Giá khởi điểm
    private Long stepPrice; // Bước giá
    private Long currentPrice;
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

