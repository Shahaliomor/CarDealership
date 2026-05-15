package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {
        Dealership dealership =null;

        try (BufferedReader read = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {

            String header = read.readLine();
            String[] headerParts = header.split("\\|");

            String dealerName = headerParts[0];
            String dealerAddress = headerParts[1];
            String dealerPhone = headerParts[2];

            dealership = new Dealership(dealerName, dealerAddress, dealerPhone);

            String line;

            while ((line = read.readLine()) != null) {

                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String colour = parts[5];
                int odoMeter = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, colour, odoMeter, price);

                dealership.addVehicle(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return dealership;
    }
}