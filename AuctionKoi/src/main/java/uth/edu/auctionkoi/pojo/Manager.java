package uth.edu.auctionkoi.pojo;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "MANAGERS")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "manager")
    private List<Staff> staffList;
}
