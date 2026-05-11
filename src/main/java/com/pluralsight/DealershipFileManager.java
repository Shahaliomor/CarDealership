package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership dealership;

    // Read dealership inventory file
    public static void readFile() {

        try {

            BufferedReader read = new BufferedReader( new FileReader("src/main/resources/inventory.csv"));

            String line;

            // Read dealership info
            String header = read.readLine();

            String[] headerParts = header.split("\\|");

            String dealerName = headerParts[0];
            String dealerAddress = headerParts[1];
            String dealerPhone = headerParts[2];

            dealership = new Dealership( dealerName, dealerAddress, dealerPhone);

            // Read vehicle data
            while ((line = read.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length != 8) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String colour = parts[5];
                    int odoMeter = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle( vin, year, make, model, vehicleType, colour, odoMeter, price);

                    // Add vehicle to dealership inventory
                    dealership.addVehicle(vehicle);

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Skipping invalid number line: " + line
                    );
                }
            }

            read.close();

        } catch (FileNotFoundException e) {

            System.out.println("Error: file not found");

        } catch (IOException e) {

            System.out.println("Error: IO Exception");
        }
    }
}