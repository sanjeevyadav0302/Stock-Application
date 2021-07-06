package com.payconiq.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {

    private int id;
    private String name;
    private double currentPrice;
    private String lastUpdate;

    public Stock() {
        this.lastUpdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }

    public Stock(int id, String name, double currentPrice) {
        super();
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
