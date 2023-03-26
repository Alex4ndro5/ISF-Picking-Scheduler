package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
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
    }
}
