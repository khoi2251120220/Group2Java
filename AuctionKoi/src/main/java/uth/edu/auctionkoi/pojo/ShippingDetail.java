package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "SHIPPING_DETAILS")
public class ShippingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String stageName;
    private LocalDateTime date;
    private String status;

    // Getters và setters cho transfer
    // Thiết lập quan hệ ManyToOne với Transfer
    @ManyToOne
    @JoinColumn(name = "transfer_id")
    private Transfer transfer;

}
