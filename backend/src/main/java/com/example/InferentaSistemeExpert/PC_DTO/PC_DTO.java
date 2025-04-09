package com.example.InferentaSistemeExpert.PC_DTO;

public class PC_DTO {
    private String name;
    private String category;
    private String processor;
    private int ram;
    private String storage;
    private String gpu;
    private double price;

    public String getName(){
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public double getPrice() {
        return price;
    }
}
