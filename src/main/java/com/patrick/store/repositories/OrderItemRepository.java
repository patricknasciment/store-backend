package com.patrick.store.repositories;

import com.patrick.store.domain.Address;
import com.patrick.store.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
