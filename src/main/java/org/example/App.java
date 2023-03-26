package org.example;
import java.io.IOException;
import java.util.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        // Variables for storing absolute path
        String storeJsonPath;
        String ordersJsonPath;

        Scanner scanner = new Scanner(System.in);
        // Getting paths from user
        System.out.print("Enter path for JSON store file:");
        storeJsonPath = scanner.nextLine();
        //storeJsonPath = "C:/Users/alekf/IdeaProjects/ISF-Picking-Scheduler/src/self-test-data/logic-bomb/store.json";
        System.out.print("Enter path for JSON orders file:");
        ordersJsonPath = scanner.nextLine();
        //ordersJsonPath = "C:/Users/alekf/IdeaProjects/ISF-Picking-Scheduler/src/self-test-data/logic-bomb/orders.json";
        scanner.close();
        // Store and orders load
        Store store = JsonReader.readStore(storeJsonPath);
        List<Order> orders = JsonReader.readOrders(ordersJsonPath);
        // Creating schedule
        OrderScheduler scheduler = new OrderScheduler();
        List<ScheduledOrder> scheduledOrders = scheduler.scheduleOrders(store, orders);
        // Printing schedule
        for (ScheduledOrder position : scheduledOrders) {
            System.out.println(position + "\n");
        }
    }
}
