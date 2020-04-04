package com.groundZer0.autobazar.datamodel.cars;

import com.groundZer0.autobazar.datamodel.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class VehicleOps {

    private static VehicleOps vehicleOps = new VehicleOps();
    /* DB of users */
    private final String file_name = "src/com/groundZer0/autobazar/datamodel/db/cars.txt";
    Path path = Paths.get(file_name);

    private ObservableList<Vehicle> list_of_vehicles;

    public void users_loading() {
        String line_file_reader;
        list_of_vehicles = FXCollections.observableArrayList();

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while ((line_file_reader = bufferedReader.readLine()) != null) {
                String[] car_information = line_file_reader.split("~");
                Vehicle new_vehicle = new Vehicle(car_information[0], car_information[1], car_information[2], Integer.parseInt(car_information[3]), Integer.parseInt(car_information[4]), car_information[5], car_information[6], car_information[7]);
                list_of_vehicles.add(new_vehicle);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
