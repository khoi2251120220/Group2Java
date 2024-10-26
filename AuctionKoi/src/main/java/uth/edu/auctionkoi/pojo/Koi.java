package uth.edu.auctionkoi.pojo;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Koi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String koiType;
    private String koiColor;
    private String auctionMethod;
    private String auctionLocation;
    private LocalDateTime auctionTime;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @OneToOne(mappedBy = "koi")
    private Auction auction;

    public String getAuctionLocation() {
        return auctionLocation;
    }

    public void setAuctionLocation(String auctionLocation) {
        this.auctionLocation = auctionLocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKoiType() {
        return koiType;
    }

    public void setKoiType(String koiType) {
        this.koiType = koiType;
    }

    public String getKoiColor() {
        return koiColor;
    }

    public void setKoiColor(String koiColor) {
        this.koiColor = koiColor;
    }

    public String getAuctionMethod() {
        return auctionMethod;
    }

    public void setAuctionMethod(String auctionMethod) {
        this.auctionMethod = auctionMethod;
    }

    public LocalDateTime getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(LocalDateTime auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
