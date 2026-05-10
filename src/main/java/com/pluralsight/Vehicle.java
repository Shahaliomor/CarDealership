package com.pluralsight;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String colour;
    private String veicleType;
    private int odoMeter;
    private Double price;

    public Vehicle(int vin, int year, String make, String model, String veicleType, String colour, int odoMeter, double price){
        this.vin=vin;
        this.year=year;
        this.make=make;
        this.model=model;
        this.veicleType=veicleType;
        this.colour=colour;
        this.odoMeter=odoMeter;
        this.price=price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getOdoMeter() {
        return odoMeter;
    }

    public Double getPrice() {
        return price;
    }
}
