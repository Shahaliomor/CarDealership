package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner input = new Scanner(System.in);

    public void display() {

        init();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("===== Car Dealership =====");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make / model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");

            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                processGetByPriceRequest();

            } else if (choice == 2) {

                processGetByMakeModelRequest();

            } else if (choice == 3) {

                processGetByYearRequest();

            } else if (choice == 4) {

                processGetByColorRequest();

            } else if (choice == 5) {

                processGetByMileageRequest();

            } else if (choice == 6) {

                processGetByTypeRequest();

            } else if (choice == 7) {

                processAllVehiclesRequest();

            } else if (choice == 8) {

                processAddVehicleRequest();

            } else if (choice == 9) {

                processRemoveVehicleRequest();

            } else if (choice == 99) {

                running = false;
                System.out.println("Goodbye!");

            } else {

                System.out.println("Invalid option");
            }
        }
    }

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    private void processGetByPriceRequest() {

        System.out.print("Enter minimum price: ");
        double min = input.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = input.nextDouble();
        input.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {

        System.out.print("Enter make: ");
        String make = input.nextLine();

        System.out.print("Enter model: ");
        String model = input.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {

        System.out.print("Enter minimum year: ");
        int min = input.nextInt();

        System.out.print("Enter maximum year: ");
        int max = input.nextInt();
        input.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByYear(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {

        System.out.print("Enter color: ");
        String color = input.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByColor(color);

        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {

        System.out.print("Enter minimum mileage: ");
        int min = input.nextInt();

        System.out.print("Enter maximum mileage: ");
        int max = input.nextInt();
        input.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByMileage(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByTypeRequest() {

        System.out.print("Enter vehicle type: ");
        String type = input.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(type);

        displayVehicles(vehicles);
    }

    private void processAllVehiclesRequest() {

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {

        System.out.print("Enter VIN: ");
        int vin = input.nextInt();

        System.out.print("Enter year: ");
        int year = input.nextInt();
        input.nextLine();

        System.out.print("Enter make: ");
        String make = input.nextLine();

        System.out.print("Enter model: ");
        String model = input.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = input.nextLine();

        System.out.print("Enter color: ");
        String color = input.nextLine();

        System.out.print("Enter mileage: ");
        int mileage = input.nextInt();

        System.out.print("Enter price: ");
        double price = input.nextDouble();
        input.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

        dealership.addVehicle(vehicle);

        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicleRequest() {

        System.out.print("Enter VIN to remove: ");
        int vin = input.nextInt();
        input.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVin() == vin) {

                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {

            dealership.removeVehicle(vehicleToRemove);


            System.out.println("Vehicle removed.");

        } else {

            System.out.println("Vehicle not found.");
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {

            System.out.println("--------------------------------");

            System.out.println("VIN: " + vehicle.getVin());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Color: " + vehicle.getColour());
            System.out.println("Mileage: " + vehicle.getOdoMeter());
            System.out.println("Price: $" + vehicle.getPrice());
        }
    }
}