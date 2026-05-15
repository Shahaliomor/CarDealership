package com.pluralsight;

import java.io.*;

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

    public static void saveDealership(Dealership dealership) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/inventory.csv"))) {

            // write dealership info
            writer.write(
                    dealership.getDealerName() + "|" +
                            dealership.getDealerAddress() + "|" +
                            dealership.getDealerPhone()
            );

            writer.newLine();

            // write vehicles
            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColour() + "|" +
                                vehicle.getOdoMeter() + "|" +
                                vehicle.getPrice()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error saving dealership.");
        }
    }
}