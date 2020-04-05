package com.groundZer0.autobazar.datamodel.cars;

public class Vehicle {
    private String id;
    private String type;
    private String headline;
    private String brand;
    private String model;
    private int price;
    private int passed_km;

    private String state;
    private String owner_email;
    private String description;

    public Vehicle(String id, String type, String headline, String brand, String model, int price, int passed_km, String state, String owner, String description) {
        this.id = id;
        this.type = type;
        this.headline = headline;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.passed_km = passed_km;
        this.state = state;
        this.owner_email = owner;
        this.description = description;
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

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public String getHeadline() {
        return headline;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String check_long_headline = this.headline;

        if(check_long_headline.length() > 40){
            check_long_headline = check_long_headline.substring(0,33) + "...";
        }

        String format = "%-40s%25s%n\n";
        return String.format(format, check_long_headline, price);
    }

    //    public abstract void testing_ride();
}
