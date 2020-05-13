package com.groundZer0.autobazar.data.cars;

import com.groundZer0.autobazar.data.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VehicleOps {

    private static VehicleOps vehicleOps = new VehicleOps();
    /* DB of users */
    private final String file_name = "src/com/groundZer0/autobazar/data/db/cars.json";
    Path path = Paths.get(file_name);

    private ObservableList<Vehicle> list_of_vehicles = FXCollections.observableArrayList();

    public void cars_loading() {
        list_of_vehicles = FXCollections.observableArrayList();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(String.valueOf(path))) {
            if(fileReader.read() == -1){
                return;
            }
            FileReader not_empty_file_reader = new FileReader(String.valueOf(path));
            Object obj = jsonParser.parse(not_empty_file_reader);

            JSONArray cars = (JSONArray) obj;

            /**
             * lambda  expression
             */
            cars.forEach( car -> parse_cars((JSONObject) car));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Vehicle> getList_of_vehicles() {
        return list_of_vehicles;
    }

    public void cars_saving() {
        JSONArray cars = new JSONArray();
        System.out.println("users length: " + list_of_vehicles.size());
        for (Vehicle vehicle : list_of_vehicles) {
            JSONObject vehicle_detail = new JSONObject();

            vehicle_detail.put("id", vehicle.getId());
            vehicle_detail.put("type", vehicle.getType());
            vehicle_detail.put("headline", vehicle.getHeadline());
            vehicle_detail.put("brand", vehicle.getBrand());
            vehicle_detail.put("model", vehicle.getModel());
            vehicle_detail.put("price", String.valueOf(vehicle.getPrice()));
            vehicle_detail.put("passed_km", String.valueOf(vehicle.getPassed_km()));
            vehicle_detail.put("state", vehicle.getState());
            vehicle_detail.put("owner_email", vehicle.getOwner_email());
            vehicle_detail.put("description", vehicle.getDescription());

            cars.add(vehicle_detail);
        }

        try (FileWriter file = new FileWriter(String.valueOf(path))) {
            file.write(cars.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse_cars(org.json.simple.JSONObject car){
        String id = (String) car.get("id");
        String type = (String) car.get("type");
        String headline = (String) car.get("headline");
        String brand = (String) car.get("brand");
        String model = (String) car.get("model");
        int price = Integer.parseInt((String) car.get("price"));
        int passed_km = Integer.parseInt((String) car.get("passed_km"));
        String state = (String) car.get("state");
        String owner_email = (String) car.get("owner_email");
        String description = (String) car.get("description");

        add_car_to_list(new Vehicle(id, type, headline, brand, model, price, passed_km, state, owner_email, description));
    }

    public static VehicleOps getVehicleOps() {
        return vehicleOps;
    }

    public void remove_vehicle(Vehicle vehicle){
        list_of_vehicles.remove(vehicle);
    }

    protected void add_car_to_list(Vehicle vehicle){
        list_of_vehicles.add(vehicle);
    }
}
