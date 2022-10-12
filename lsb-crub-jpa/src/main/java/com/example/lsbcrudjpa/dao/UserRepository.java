package com.example.lsbcrudjpa.dao;

import com.example.lsbcrudjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Long countByName(String lastname);

    List<User> findByAdressOrderByName(String adress);

    Page<User> queryFirst10ByAdress(String adress, Pageable pageable);

    Page<User> findByAdress(String adress, Pageable pageable);
}
