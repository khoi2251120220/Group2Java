package uth.edu.auctionkoi.pojo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "BUYERS")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;  // Đổi từ SecurityProperties.User thành User của bạn

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {  // Đổi kiểu trả về thành User
        return user;
    }

    public void setUser(User user) {  // Đổi tham số thành User
        this.user = user;
    }
}
