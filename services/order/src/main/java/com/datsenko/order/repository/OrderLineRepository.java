package com.datsenko.order.repository;

import com.datsenko.order.entity.OrderLine;
import com.datsenko.order.entity.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
