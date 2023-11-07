# ISF-Picking-Scheduler
This project was prepared for Ocado Technology Internship recruitment.

The ISF Picking Scheduler is a Java application designed for scheduling order picking in an inventory management system. It provides a straightforward interface for users to specify the paths to JSON files containing store and order data, and it produces a schedule for efficient order picking.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [License](#license)

## Introduction

Efficient order picking is a crucial part of managing an inventory. The ISF Picking Scheduler simplifies the process by allowing users to input the paths to JSON files containing store information and order details. It then generates a schedule to optimize the order-picking process, helping businesses save time and resources.

## Getting Started

Before using the ISF Picking Scheduler, you should ensure that you have Java installed on your system.

## Usage

1. **Compile the Application**: Compile the Java application using your preferred Java development environment or by running the following command:

   ```
   javac App.java
   ```
2. **Run the Application**: Execute the application by running the following command:

   ```
   java App
   ```

3. **Input JSON Paths**: You will be prompted to enter the paths to the JSON files containing store and order data. Provide the absolute paths to these files or use Gui to find files.

4. **View the Schedule**: The application will process the data and display the schedule for efficient order picking.

5. **Exit**: Once you've reviewed the schedule, you can exit the application.

Here's a code snippet from the `App.java` file:

```
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
        System.out.print("Enter path for JSON orders file:");
        ordersJsonPath = scanner.nextLine();
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
```
## License

This ISF Picking Scheduler application is available under the MIT License. For more details, please refer to the [LICENSE](LICENSE) file.

**Optimize your order-picking process with the ISF Picking Scheduler!**

