package com.assignment.service;

import com.assignment.exception.CustomerNotFoundException;
import com.assignment.exception.ExistingOrderException;
import com.assignment.exception.OrderNotFoundException;
import java.util.Optional;
import com.assignment.model.OrderDetails;
import java.util.List;

public interface OrderService
{
    List<OrderDetails> getAllOrdersService() throws InterruptedException;
    
    Optional<OrderDetails> getOrderService(final int orderId) throws OrderNotFoundException, InterruptedException;
    
    OrderDetails newOrderService(final OrderDetails orderDetails) throws ExistingOrderException;
    
    OrderDetails updateOrderService(final OrderDetails orderDetails);
    
    String deleteOrderService(final int orderId) throws OrderNotFoundException;
    
    List<OrderDetails> getCustomerOrderService(final int customerId) throws CustomerNotFoundException;
}