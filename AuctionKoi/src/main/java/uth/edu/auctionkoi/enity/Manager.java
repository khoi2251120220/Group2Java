package uth.edu.auctionkoi.enity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "manager")
    private List<Staff> staffList;
}
