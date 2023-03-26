package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderScheduler {
    public static List<Order> scheduleOrders(Store store, List<Order> orders) {
        List<Order> scheduledOrders = new ArrayList<>();
        LocalTime currentTime = store.getPickingStartTime();

        while (!orders.isEmpty() && currentTime.isBefore(store.getPickingEndTime())) {
            String currentPicker = store.getPickers().get(0);

            for (int i = 0; i < orders.size(); i++) {
                Order currentOrder = orders.get(i);

                if (currentOrder.getCompleteBy().isBefore(currentTime.plus(currentOrder.getPickingTime()))) {
                    orders.remove(i);
                    i--;
                } else {
                    scheduledOrders.add(new Order(currentOrder.getOrderId(), currentOrder.getOrderValue(),
                            currentOrder.getPickingTime(), currentTime.plus(currentOrder.getPickingTime())));
                    store.getPickers().remove(0);
                    store.getPickers().add(currentPicker);
                    break;
                }
            }

            currentTime = currentTime.plus(Duration.ofMinutes(1));
        }

        return scheduledOrders;
    }
}
