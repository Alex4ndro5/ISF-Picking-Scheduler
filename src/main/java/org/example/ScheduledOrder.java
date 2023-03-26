package org.example;

import java.time.LocalTime;

public class ScheduledOrder {
    public String pickerId;
    public String assignedOrderId;
    public LocalTime assignedPickingStartTime;

    public ScheduledOrder(String pickerId, String assignedOrderId, LocalTime assignedPickingStartTime){
        this.pickerId = pickerId;
        this.assignedOrderId = assignedOrderId;
        this.assignedPickingStartTime = assignedPickingStartTime;
    }
    @Override
    public String toString() {
        return "Picker: " + pickerId + ", Order ID: " + assignedOrderId + ", Picking Start Time: " + assignedPickingStartTime;
    }

}
