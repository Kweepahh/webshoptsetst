package org.example.zaalschoenenwebshop.dao;


import org.example.zaalschoenenwebshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
