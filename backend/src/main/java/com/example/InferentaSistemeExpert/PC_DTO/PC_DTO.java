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

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorsge(String storsge) {
        this.storage = storsge;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
