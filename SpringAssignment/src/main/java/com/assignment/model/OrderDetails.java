package com.assignment.model;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class OrderDetails
{
    @Id
    private int orderId;
    private int customerId;
    private String orderDetails;
    private String orderDate;
    private String shippingDate;
    
    public OrderDetails() {
    }
    
    public OrderDetails(final int orderId, final int customerId, final String orderDetails, final String orderDate, final String shippingDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
    }
    
    public int getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(final int orderId) {
        this.orderId = orderId;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(final int customerId) {
        this.customerId = customerId;
    }
    
    public String getOrderDetails() {
        return this.orderDetails;
    }
    
    public void setOrderDetails(final String orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(final String orderDate) {
        this.orderDate = orderDate;
    }
    
    public String getShippingDate() {
        return this.shippingDate;
    }
    
    public void setShippingDate(final String shippingDate) {
        this.shippingDate = shippingDate;
    }
}