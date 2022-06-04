package com.aliakpinar.transactionmanagement.repository;

import com.aliakpinar.transactionmanagement.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
