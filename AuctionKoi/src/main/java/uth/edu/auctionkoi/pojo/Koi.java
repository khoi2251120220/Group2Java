package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "KOIS")
public class Koi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String koiType;
    private String koiColor;
    private int koiAge;
    private double koiWeight;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @OneToOne(mappedBy = "koi")
    private Auction auction;

}
