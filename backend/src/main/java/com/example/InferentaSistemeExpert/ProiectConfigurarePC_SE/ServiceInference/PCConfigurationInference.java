package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ServiceInference;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCConfigurationInference {

    private List<PC> PCList;

    public PCConfigurationInference(List<PC> PCList){
        this.PCList = PCList;
    }

    //Metoda care gaseste PC-urile potrivite in functie de parametrii
    public boolean BackwardChaining(String name, String category, String processor, int ram, String storage, String gpu, double price) {
        for (PC pc : this.PCList) {
            if (pc.getName().equals(name) && pc.getCategory().equals(category) && checkCharacteristics(pc, processor, ram, storage, gpu, price)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCharacteristics(PC pc, String processor, int ram, String storage, String gpu, double price) {

        if(pc.getPrice() <= price &&
                pc.getRam() >= ram &&
                pc.getProcessor().equals(processor) &&
                pc.getStorage().equals(storage) &&
                pc.getGpu().equals(gpu)){
            return true;
        }

        return false;
    }

}
