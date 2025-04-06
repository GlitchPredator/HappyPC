<<<<<<< HEAD
package com.example.ProiectConfigurarePC_SE.ServiceInference;
=======
package src.main.java.com.example.ProiectConfigurarePC_SE.ServiceInference;
>>>>>>> 3957b83 (Add maven dependencies)

import com.example.ProiectConfigurarePC_SE.PC.PC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCConfigurationInference {

    private List<PC> PCList;

    public PCConfigurationInference(List<PC> PCList){
        this.PCList = PCList;
    }

    //Metoda care gaseste PC-urile potrivite in functie de parametrii
<<<<<<< HEAD
    public boolean BackwardChaining(String name, String category, String processor, int ram, String storage, String gpu, double price) {
        for (PC pc : this.PCList) {
            if (pc.getName().equals(name) && pc.getCategory().equals(category) && checkCharacteristics(pc, processor, ram, storage, gpu, price)) {
=======
    public boolean BackwardChaining(String type, double maxPrice, int minResolution, double minBattery, double minPerformance) {
        for (PC pc : this.PCList) {
            if (pc.getType().equalsIgnoreCase(type) && checkCharacteristics(pc, maxPrice, minResolution, minBattery, minPerformance)) {
>>>>>>> 3957b83 (Add maven dependencies)
                return true;
            }
        }
        return false;
    }

<<<<<<< HEAD
    private boolean checkCharacteristics(PC pc, String processor, int ram, String storage, String gpu, double price) {

        if(pc.getPrice() <= price &&
                pc.getRam() >= ram &&
                pc.getProcessor().equals(processor) &&
                pc.getStorage().equals(storage) &&
                pc.getGpu().equals(gpu)){
=======
    private boolean checkCharacteristics(PC pc, double maxPrice, int minResolution, double minBattery, double minPerformance) {

        if(pc.getPrice() <= maxPrice &&
                pc.getResolution() >= minResolution &&
                pc.getBattery() >= minBattery &&
                pc.getPerformace() >= minPerformance){
>>>>>>> 3957b83 (Add maven dependencies)
            return true;
        }

        return false;
    }

}
