package uth.edu.auctionkoi.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;  // Đổi từ SecurityProperties.User thành User của bạn

    @OneToMany(mappedBy = "buyer")
    private List<Transaction> transactions;

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
