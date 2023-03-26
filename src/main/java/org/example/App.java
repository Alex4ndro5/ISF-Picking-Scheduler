package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

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
        System.out.print("Enter path for JSON orders file:");
        ordersJsonPath = scanner.nextLine();
        scanner.close();

        // Wczytanie danych z plików JSON
        Store store = JsonReader.readStore(storeJsonPath);
        List<Order> orders = JsonReader.readOrders(ordersJsonPath);

        // Stworzenie harmonogramu kompletowania zamówień
        OrderScheduler scheduler = new OrderScheduler();
        List<Order> scheduledOrders = scheduler.scheduleOrders(store, orders);

        // Wypisanie zaplanowanych zamówień dla każdego pracownika
        for (String picker : store.getPickers()) {
            System.out.println("Picker " + picker + ":");
            for (Order order : scheduledOrders) {
                if (order.getPicker() != null && order.getPicker().equals(picker)) {
                    System.out.println("- Order " + order.getOrderId());
                }
            }
        }
    }
}
