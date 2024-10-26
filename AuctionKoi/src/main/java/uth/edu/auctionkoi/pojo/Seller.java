package uth.edu.auctionkoi.pojo;

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
    private User user;  // Đổi từ SecurityProperties.User thành User của bạn

    @OneToMany(mappedBy = "seller")
    private List<Koi> koiList;

    public User getUser() {  // Đổi kiểu trả về thành User
        return user;
    }

    public void setUser(User user) {  // Đổi tham số thành User
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
