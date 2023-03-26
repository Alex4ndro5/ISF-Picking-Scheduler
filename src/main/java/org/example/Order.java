package org.example;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

    public class Order {
        public String orderID;
        public BigDecimal orderValue;
        public Duration pickingTime;
        public LocalTime completeBy;
        public Order(){

    }
    public Order(String _orderID, BigDecimal _orderValue, Duration _pickingTime, LocalTime _completeBy){
        this.orderID = _orderID;
        this.orderValue = _orderValue;
        this.pickingTime = _pickingTime;
        this.completeBy = _completeBy;
    }
}
