package uth.edu.auctionkoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uth.edu.auctionkoi.pojo.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
