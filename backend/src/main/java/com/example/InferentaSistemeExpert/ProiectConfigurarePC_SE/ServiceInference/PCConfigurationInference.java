package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ServiceInference;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;
import org.springframework.stereotype.Service;
import com.example.InferentaSistemeExpert.PcKnowledgeBase;
import java.io.IOException;

@Service
public class PCConfigurationInference {

    //Metoda care gaseste PC-urile potrivite in functie de parametrii
    public String BackwardChaining(String name, String category, int ram, String storage, double price) throws IOException{
        for (PC pc : PcKnowledgeBase.pcs) {
            if (pc.getName().contains((name)) && pc.getCategory().equals(category) && checkCharacteristics(pc, category, ram, storage, price)) {
                return "PC recomandat: " + pc.getName() + " " + pc.getProcessor() + " " + pc.getRam() + " " + pc.getStorage() + " " + pc.getGpu() + " la pretul de " + pc.getPrice() + "RON.\nLink: " + pc.getLink();
            }
        }

        return "Nu s-a gasit niciun PC recomandat!";
    }

    private boolean checkCharacteristics(PC pc, String category, int ram, String storage, double price) {
        if (category.contains("office")) {
            if ((price <= pc.getPrice() || price > pc.getPrice()) && pc.getStorage().contains(storage))
                return true;
        }
        else if (category.contains("gaming")){
            if ((price <= pc.getPrice()  || price > pc.getPrice()) && (pc.getName().contains("Myria") || pc.getName().contains("Lenovo") || pc.getName().contains("ASUS")))
                return true;
        }
        else { // design
            if ((price <= pc.getPrice() || price >= pc.getPrice()) && (pc.getRam() <= ram || pc.getRam() >= ram))
                return true;
        }

        return false;
    }
}
