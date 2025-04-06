<<<<<<< HEAD
package com.example.ProiectConfigurarePC_SE.PC;

public class PC {
    String name, category, processor, storage, gpu;
    int ram;
    double price;

    public PC(String name, String category, String processor, int ram, String storage, String gpu, double price) {
        this.name = name;
        this.category = category;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getProcessor() {
        return processor;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public int getRam() {
        return ram;
=======
package src.main.java.com.example.ProiectConfigurarePC_SE.PC;

public class PC {

    private String type;

    private double price;

    private int resolution;

    private double battery;

    private double performace;

    public PC(String type, double price, int resolution, double battery, double performance){
        this.type = type;
        this.price = price;
        this.resolution = resolution;
        this.battery = battery;
        this.performace = performance;
    }

    public String getType() {
        return type;
>>>>>>> 3957b83 (Add maven dependencies)
    }

    public double getPrice() {
        return price;
    }

<<<<<<< HEAD
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
=======
    public int getResolution() {
        return resolution;
    }

    public double getBattery() {
        return battery;
    }

    public double getPerformace() {
        return performace;
    }

    public void setType(String type) {
        this.type = type;
>>>>>>> 3957b83 (Add maven dependencies)
    }

    public void setPrice(double price) {
        this.price = price;
    }
<<<<<<< HEAD
=======

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public void setPerformace(double performace) {
        this.performace = performace;
    }
>>>>>>> 3957b83 (Add maven dependencies)
}
