package com.example.InferentaSistemeExpert;

import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;

import java.util.*;

public class PcKnowledgeBase {
    public static List<PC> pcs = new ArrayList<>();

    static {
        pcs.add(new PC("HP ProOne 440 G9", "office", "Intel Core i7-13700T", 16, "512GB SSD", "Intel UHD 770", 4399.99));
        pcs.add(new PC("Office Master", "office", "AMD Ryzen 5 2400G", 16, "1000GB SSD", "Radeon Vega11", 1899.99));
        pcs.add(new PC("Diaxxa i5-12600K", "office", "Intel i5-12600K", 16, "512GB SSD", "Intel UHD 770", 2199.00));
        pcs.add(new PC("Myria Digital 38", "gaming_entry", "Intel Core i3-13100F", 16, "512GB SSD", "AMD Radeon RX 550", 2249.90));
        pcs.add(new PC("Myria Style V87", "gaming_entry", "AMD Ryzen 5 7600", 16, "500GB SSD", "NVIDIA GTX 1650", 3499.99));
        pcs.add(new PC("Lenovo LOQ 17IRR9", "gaming_mid", "Intel Core i7-14700F", 16, "1TB SSD", "NVIDIA RTX 4060", 6299.99));
        pcs.add(new PC("ASUS G13CHR", "gaming_mid", "Intel Core i7-14700", 16, "1TB SSD", "NVIDIA RTX 4060", 9499.99));
        pcs.add(new PC("Myria Creator V3W", "gaming_high", "Intel Core i9-14900F", 64, "2TB SSD", "NVIDIA RTX 4090", 22499.99));
        pcs.add(new PC("Acer ConceptD 500", "design", "Intel Core i9 12th Gen", 128, "4TB SSD", "NVIDIA RTX A4000", 4500.40));
        pcs.add(new PC("Dell Precision 3660", "design", "Intel Core i7 12th Gen", 16, "512GB SSD", "NVIDIA RTX A2000", 6087.99));
        pcs.add(new PC("Lenovo Legion Tower 5i Gen 8", "design", "Intel Core i7 13th Gen", 16, "512GB SSD + 1TB HDD", "NVIDIA RTX 3060", 3736.74));
        pcs.add(new PC("Apple Mac Studio M2 Ultra", "design", "Apple M2 Ultra", 64, "1TB SSD", "Integrated GPU 60 cores", 2086.22));
        pcs.add(new PC("HP ENVY 34-c0050", "design", "Intel Core i7-11700", 32, "1TB SSD", "NVIDIA RTX 3060", 26389.93));
        pcs.add(new PC("HPE ProLiant DL20", "server", "Intel Xeon E-2436", 32, "960GB SSD", "None", 12078.31));
        pcs.add(new PC("Dell PowerEdge T150", "server", "Intel Xeon E-2378", 64, "2TB HDD + 960GB SSD", "None", 14936.23));
        pcs.add(new PC("Dell PowerEdge R360", "server", "Intel Xeon E-2434", 16, "600GB HDD", "None", 10646.18));
    }
    
//pc cu un processor bun si pret mai mic decat 3000
    public static List<PC> getAffordableEfficientPCs() {
        List<String> goodProcessors = Arrays.asList("Intel i5-12600K", "AMD Ryzen 5 7600", "Intel Core i3-13100F");
        List<PC> results = new ArrayList<>();
        for (PC pc : pcs) {
            if (goodProcessors.contains(pc.getProcessor()) && pc.getPrice() > 0 && pc.getPrice() <= 3000) {
                results.add(pc);
            }
        }
        return results;
    }

//pc pentru editare video cu un pret mai mic de 6000
    public static List<PC> getAffordableVideoEditingPCs() {
        List<String> goodGPUs = Arrays.asList("NVIDIA RTX A4000", "NVIDIA RTX A2000", "NVIDIA RTX 3060");
        List<PC> results = new ArrayList<>();
        for (PC pc : pcs) {
            if ("design".equals(pc.getCategory()) && pc.getRam() >= 16 && goodGPUs.contains(pc.getGpu()) && pc.getPrice()> 0 && pc.getPrice() <= 6000) {
                results.add(pc);
            }
        }
        return results;
    }

//cel mai bun pc in functie de un buget   
    public static PC getBestSystemForBudget(double budget) {
        PC bestPC = null;
        for (PC pc : pcs) {
            if (pc.getPrice() > 0 && pc.getPrice() <= budget) {
                if (bestPC == null || pc.getPrice() > bestPC.getPrice()) {
                    bestPC = pc;
                }
            }
        }
        return bestPC;
    }

    public static void main(String[] args) {
        System.out.println("Affordable and efficient PCs:");
        for (PC pc : getAffordableEfficientPCs()) {
            System.out.println(pc.getName());
        }
        
        System.out.println("\nAffordable video editing PCs:");
        for (PC pc : getAffordableVideoEditingPCs()) {
            System.out.println(pc.getName());
        }
        
        double budget = 5000;
        PC bestPC = getBestSystemForBudget(budget);
        System.out.println("\nBest PC under " + budget + " Lei:");
        if (bestPC != null) {
            System.out.println(bestPC.getName() + " - " + bestPC.getName() + " Lei");
        } else {
            System.out.println("No PC found within budget.");
        }
    }
}
