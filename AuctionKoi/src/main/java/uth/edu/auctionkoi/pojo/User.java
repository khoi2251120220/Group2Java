package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", columnDefinition = "NVARCHAR(255)")
    private String fullName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address", columnDefinition = "NVARCHAR(500)")
    private String address;
    @Column(name = "role")
    private Role role;

    public enum Role {
        GUEST, MEMBER, KOI_BREEDER, STAFF, MANAGER
    }
}
