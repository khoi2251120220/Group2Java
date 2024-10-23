package uth.edu.auctionkoi.enity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal bidDecimal;
    private LocalDateTime bidTime;
    private String status;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public BigDecimal getBidDecimal() {
        return bidDecimal;
    }

    public void setBidDecimal(BigDecimal bidDecimal) {
        this.bidDecimal = bidDecimal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
