package uth.edu.auctionkoi.enity;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.util.List;
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String itemName;
    private String itemType;
    private String itemLocation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private SecurityProperties.User user;

    @OneToMany(mappedBy = "seller")
    private List<Koi> koiList;

    public SecurityProperties.User getUser() {
        return user;
    }

    public void setUser(SecurityProperties.User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public List<Koi> getKoiList() {
        return koiList;
    }

    public void setKoiList(List<Koi> koiList) {
        this.koiList = koiList;
    }
}
