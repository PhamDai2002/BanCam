package com.shop.bran.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.bran.entity.Order;

public interface IOrderReponsitory extends JpaRepository<Order, Integer>{

}
