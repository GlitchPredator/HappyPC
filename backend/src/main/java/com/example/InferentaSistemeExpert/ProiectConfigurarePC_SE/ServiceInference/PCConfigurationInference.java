package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ServiceInference;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;
import org.springframework.stereotype.Service;
import com.example.InferentaSistemeExpert.PcKnowledgeBase;
import java.util.List;

@Service
public class PCConfigurationInference {

    //Metoda care gaseste PC-urile potrivite in functie de parametrii
    public String BackwardChaining(String name, String category, int ram, String storage, double price) {
        for (PC pc : PcKnowledgeBase.pcs) {
            if ((pc.getName().contains("ASUS") || pc.getName().contains("Myria") || pc.getName().contains("Lenovo")) && pc.getCategory().equals(category) && checkCharacteristics(pc, ram, storage, price)) {
                return "PC recomandat: " + pc.getName() + " " + pc.getProcessor() + " " + pc.getRam() + " " + pc.getStorage() + " " + pc.getGpu() + " " + pc.getPrice();
            }
        }

        return "Nu s-a gasit niciun PC recomandat!";
    }

    private boolean checkCharacteristics(PC pc, int ram, String storage, double price) {

        if(pc.getPrice() <= price &&
                pc.getRam() >= ram &&
                pc.getStorage().contains(storage)){
            return true;
        }

        return false;
    }
}
