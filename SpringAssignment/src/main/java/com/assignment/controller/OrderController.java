package com.assignment.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.assignment.exception.ExistingOrderException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.exception.CustomerNotFoundException;
import com.assignment.exception.OrderNotFoundException;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.assignment.model.OrderDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.assignment.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/myapp")
public class OrderController
{
    @Autowired
    OrderService orderService;
    
    @GetMapping({ "/getAllOrders" })
    public List<OrderDetails> getAllOrders() throws InterruptedException {
        return (List<OrderDetails>)orderService.getAllOrdersService();
    }
    
    @GetMapping({ "/getOrder/{orderId}" })
    public Optional<OrderDetails> getOrder(@PathVariable("orderId")  int orderId) throws OrderNotFoundException, InterruptedException {
        return (Optional<OrderDetails>)orderService.getOrderService(orderId);
    }
    
    @GetMapping({ "/getCustomerOrder/{customerId}" })
    public List<OrderDetails> getCustomerOrder(@PathVariable("customerId")  int customerId) throws CustomerNotFoundException {
        return (List<OrderDetails>)orderService.getCustomerOrderService(customerId);
    }
    
    @PostMapping(path = { "/newOrder" })
    public OrderDetails newOrder(@RequestBody  OrderDetails orderDetails) throws ExistingOrderException {
        return orderService.newOrderService(orderDetails);
    }
    
    @PutMapping(path = { "/updateOrder" })
    public OrderDetails updateOrder(@RequestBody  OrderDetails orderDetails) {
        return orderService.updateOrderService(orderDetails);
    }
    
    @DeleteMapping({ "/deleteOrder/{orderId}" })
    public String deleteOrder(@PathVariable("orderId")  int orderId) throws OrderNotFoundException {
        String deletedOrder = orderService.deleteOrderService(orderId);
        return deletedOrder;
    }
}