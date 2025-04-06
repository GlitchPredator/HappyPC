package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC;

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
    }

    public double getPrice() {
        return price;
    }

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
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
