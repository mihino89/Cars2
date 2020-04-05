package com.groundZer0.autobazar.datamodel.cars;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VehicleOps {

    private static VehicleOps vehicleOps = new VehicleOps();
    /* DB of users */
    private final String file_name = "src/com/groundZer0/autobazar/datamodel/db/cars.txt";
    Path path = Paths.get(file_name);

    private ObservableList<Vehicle> list_of_vehicles;

    public void cars_loading() {
        String line_file_reader;
        list_of_vehicles = FXCollections.observableArrayList();

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while ((line_file_reader = bufferedReader.readLine()) != null) {
                String[] car_information = line_file_reader.split("~");
                Vehicle new_vehicle = new Vehicle(car_information[0],car_information[1], car_information[2], car_information[3], Integer.parseInt(car_information[4]), Integer.parseInt(car_information[5]), car_information[6], car_information[7], car_information[8]);
                list_of_vehicles.add(new_vehicle);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cars_saving() throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);

        try{
            for(Vehicle vehicle : list_of_vehicles){
                bufferedWriter.write(String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s",
                        vehicle.getType(),
                        vehicle.getHeadline(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getPrice(),
                        vehicle.getPassed_km(),
                        vehicle.getState(),
                        vehicle.getOwner(),
                        vehicle.getDescription()
                ));
                bufferedWriter.newLine();
            }
        } finally {
            bufferedWriter.close();
        }
    }

    public static VehicleOps getVehicleOps() {
        return vehicleOps;
    }

    public ObservableList<Vehicle> getList_of_vehicles() {
        return list_of_vehicles;
    }
}
