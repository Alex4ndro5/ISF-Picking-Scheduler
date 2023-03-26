package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderScheduler {
    public static List<ScheduledOrder> scheduleOrders(Store store, List<Order> orders) {
        List<ScheduledOrder> scheduledOrders = new ArrayList<>();
        LocalTime currentTime = store.getPickingStartTime();
        int numPickers = store.getPickers().size();
        int ordersPerPicker = (int) Math.ceil((double) orders.size() / numPickers); // Round up to ensure that each picker gets at least one order

        // Keep track of the current time for each picker
        Map<String, LocalTime> pickerTimes = new HashMap<>();
        for (String picker : store.getPickers()) {
            pickerTimes.put(picker, store.getPickingStartTime());
        }

        for (int i = 0; i < numPickers; i++) {
            String currentPicker = store.getPickers().get(i);
            int ordersAssigned = 0;

            for (Order order : orders) {
                if (ordersAssigned >= ordersPerPicker) {
                    break;
                }

                // Get the current time for the current picker
                LocalTime pickerTime = pickerTimes.get(currentPicker);

                String currentOrder = order.getOrderId();
                LocalTime currentOrderTime = pickerTime.plus(order.getPickingTime());
                if (currentOrderTime.isAfter(store.getPickingEndTime())){ break;}
                ScheduledOrder position = new ScheduledOrder(currentPicker, currentOrder, currentOrderTime);
                scheduledOrders.add(position);

                // Update the current time for the current picker
                pickerTimes.put(currentPicker, currentOrderTime);

                ordersAssigned++;
            }
        }

        return scheduledOrders;
    }
}
