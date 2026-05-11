package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String dealerName;
    private String dealerAddress;
    private String dealerPhone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String dealerName, String dealerAddress, String dealerPhone){
        this.dealerName=dealerName;
        this.dealerAddress=dealerAddress;
        this.dealerPhone=dealerPhone;
        this.inventory=new ArrayList<>();
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();

        for (int i = 0; i < inventory.size(); i++) {

            Vehicle vehicle = inventory.get(i);

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesByPrice.add(vehicle);
            }
        }

        return vehiclesByPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {result.add(vehicle);
            }
        }

        return result;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                result.add(vehicle);
            }
        }

        return result;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdoMeter() >= min && vehicle.getOdoMeter() <= max) {
                result.add(vehicle);
            }
        }

        return result;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(vehicle);
            }
        }

        return result;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColour().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }

        return result;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }
    //here in inventory we send the list of all car one by one
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

}
