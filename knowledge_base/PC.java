import java.util.*;

class PC {
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
}
