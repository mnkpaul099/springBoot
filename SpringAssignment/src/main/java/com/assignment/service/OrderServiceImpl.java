package com.assignment.service;

import com.assignment.exception.ExistingOrderException;
import com.assignment.exception.CustomerNotFoundException;
import com.assignment.exception.OrderNotFoundException;
import java.util.Optional;
import com.assignment.model.OrderDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.assignment.dao.OrderDetailsDao;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    OrderDetailsDao orderdao;
    
    @Override
    //@Cacheable(value="order-cache", key="#orderId")
    public List<OrderDetails> getAllOrdersService() throws InterruptedException {
    	//Thread.sleep(5000);
        return (List<OrderDetails>)orderdao.findAll();
    }
    
    @Override
    @Cacheable(value="order-cache", key="#orderId")
    public Optional<OrderDetails> getOrderService(int orderId) throws OrderNotFoundException, InterruptedException {
    	Thread.sleep(5000);
        if (!orderdao.existsById(orderId)) {
            throw new OrderNotFoundException("Invalid Data!");
        }
        return (Optional<OrderDetails>)orderdao.findById(orderId);
    }
    
    @Override
    public List<OrderDetails> getCustomerOrderService(int customerId) throws CustomerNotFoundException {
        if (!orderdao.existsByCustomerId(customerId)) {
            throw new CustomerNotFoundException("Invalid Data!");
        }
        return orderdao.findByCustomerId(customerId);
    }
    
    @Override
    public OrderDetails newOrderService(OrderDetails orderDetails) throws ExistingOrderException {
        if (orderdao.existsById(orderDetails.getOrderId())) {
            throw new ExistingOrderException("Invalid Data!");
        }
        orderdao.save(orderDetails);
        return orderDetails;
    }
    
    @Override
    public OrderDetails updateOrderService(OrderDetails orderDetails) {
        orderdao.save(orderDetails);
        return orderDetails;
    }
    
    @Override
    public String deleteOrderService(int orderId) throws OrderNotFoundException {
        OrderDetails orderDetails = (OrderDetails)orderdao.getOne(orderId);
        if (!orderdao.existsById(orderId)) {
            throw new OrderNotFoundException("Invalid Data!");
        }
        orderdao.delete(orderDetails);
        return "order deleted!";
    }
}