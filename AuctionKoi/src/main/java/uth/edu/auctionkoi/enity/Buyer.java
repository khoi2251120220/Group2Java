package uth.edu.auctionkoi.enity;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.util.List;
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private SecurityProperties.User user;
    @OneToMany(mappedBy = "buyer")
    private List<Transaction> transactions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SecurityProperties.User getUser() {
        return user;
    }

    public void setUser(SecurityProperties.User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
