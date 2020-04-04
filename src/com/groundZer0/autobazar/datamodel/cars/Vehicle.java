package com.groundZer0.autobazar.datamodel.cars;

public class Vehicle {
    private String type;
    private String brand;
    private String model;
    private int price;
    private int passed_km;

    private String state;
    private String owner;
    private String description;

    public Vehicle(String type, String brand, String model, int price, int passed_km, String state, String owner, String description) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.passed_km = passed_km;
        this.description = description;
        this.state = state;
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getPassed_km() {
        return passed_km;
    }

    public String isState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }

    //    public abstract void testing_ride();
}
