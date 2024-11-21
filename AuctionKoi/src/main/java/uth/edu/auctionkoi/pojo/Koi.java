package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "KOIS")
public class Koi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "koi_name")
    private String koiName;

    @Column(name = "koi_type")
    private String koiType;

    @Column(name = "koi_color")
    private String koiColor;

    @Column(name = "koi_age")
    private int koiAge;

    @Column(name = "koi_weight")
    private double koiWeight;

    @Column(name = "koi_image")
    private String koiImage;

    @Column(name = "koi_image_logo")
    private String koiImageLogo; // Thêm cột cho ảnh logo

    @Column(name = "koi_price")
    private String koiPrice;

    @ManyToOne
    @JoinColumn(name = "breeder_id")
    private User breeder;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public enum Status {
        PENDING, AUCTIONED, SOLD
    }
}
