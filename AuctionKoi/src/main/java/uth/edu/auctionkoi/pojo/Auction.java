package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "AUCTIONS")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal initialPrice;
    private BigDecimal finalPrice;
    private LocalDateTime auctionStartTime;
    private LocalDateTime auctionEndTime;
    private String status;

    @Enumerated(EnumType.STRING)
    private AuctionMethod method;

    @OneToOne
    @JoinColumn(name = "koi_id")
    private Koi koi;
}

