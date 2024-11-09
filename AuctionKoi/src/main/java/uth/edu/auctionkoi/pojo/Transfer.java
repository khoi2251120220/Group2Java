package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "TRANSFERS")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal transferAmount;
    private LocalDateTime createDeliveryDate;
    private LocalDateTime expectedDeliveryDate;
    private double weight;
    private String statusPayment;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    // Getters và setters cho shippingDetails
    // Thiết lập quan hệ OneToMany với ShippingDetail
    @OneToMany(mappedBy = "transfer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShippingDetail> shippingDetails;

}
