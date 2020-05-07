package com.assignment.dao;

import java.util.List;
import com.assignment.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer>
{
    List<OrderDetails> findByCustomerId(final int orderId);
    
    boolean existsByCustomerId(final int customerId);
}
