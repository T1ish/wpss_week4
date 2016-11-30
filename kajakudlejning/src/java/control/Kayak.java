/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Z
 */
public class Kayak {
    private int id;
    private String name;
    private String model;
    private String description;
    private int year;
    private String color;
    private double length;

    public Kayak() {
    }

    public Kayak(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Kayak(int id, String name, String model, String description, int year, String color, double length) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.description = description;
        this.year = year;
        this.color = color;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
}
