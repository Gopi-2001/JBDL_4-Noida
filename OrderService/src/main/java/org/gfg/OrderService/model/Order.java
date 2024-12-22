package org.gfg.OrderService.model;

import java.util.Date;


public class Order {

    String name;
    String description;
    double price;
    Date date;

    public Order(String name, String description, double price, Date date) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
