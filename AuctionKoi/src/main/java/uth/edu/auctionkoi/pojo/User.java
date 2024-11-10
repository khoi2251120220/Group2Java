package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String address;
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Seller seller;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Buyer buyer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Staff staff;

}
