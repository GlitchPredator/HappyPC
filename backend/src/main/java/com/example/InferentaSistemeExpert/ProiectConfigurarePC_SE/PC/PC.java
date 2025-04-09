package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC;

public class PC {
    String name, category, processor, storage, gpu, link;
    int ram;
    double price;

    public PC(String name, String category, String processor, int ram, String storage, String gpu, double price, String link) {
        this.name = name;
        this.category = category;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.price = price;
        this.link = link;
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

    public String getLink() { return link; }

    public int getRam() {
        return ram;
    }

    public double getPrice() {
        return price;
    }
}
