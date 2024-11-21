package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    private Double amount; // Số tiền
    private String paymentMethod; // Hình thức thanh toán (Bank Transfer, Cash, ...)

    @Enumerated(EnumType.STRING)
    private Status status; // Trạng thái giao dịch

    private LocalDateTime transactionDate;

    public enum Status {
        PENDING, SUCCESS, FAILED
    }

}
