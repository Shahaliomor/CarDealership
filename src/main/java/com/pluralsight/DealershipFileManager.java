package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    public static ArrayList<Vehicle> vehicles= new ArrayList<>();

    // Read all transactions from CSV file and store in ArrayList
    public static void readFile(){
        try {
            BufferedReader read= new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line;
            //read header line.
            read.readLine();

            while ((line=read.readLine())!=null){
                if(line.trim().isEmpty()){
                    continue;
                }

                String[] parts=line.split("\\|");

                if(parts.length!=8){
                    System.out.println("Skipping invalid line: "+ line);
                    continue;
                }

                try {
                    int vin=Integer.parseInt(parts[0]);
                    int year=Integer.parseInt(parts[1]);
                    String make=parts[2];
                    String model=parts[3];
                    String vehicleType=parts[4];
                    String colour=parts[5];
                    int OdoMeter=Integer.parseInt(parts[6]);
                    double price= Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, colour, OdoMeter, price);
                    //adding to arrayList
                    vehicles.add(vehicle);

                }catch (NumberFormatException e) {
                    System.out.println("⚠ Skipping invalid amount line: " + line);
                    continue;
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.print("Error: file not found");
        } catch (IOException e) {
            System.out.print("Error: IO Exception");
        }
    }


}
