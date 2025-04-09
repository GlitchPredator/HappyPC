import java.util.*;

public class PcKnowledgeBase {
    static List<PC> pcs = new ArrayList<>();

    static {
        pcs.add(new PC("HP ProOne 440 G9", "office", "Intel Core i7-13700T", 16, "512GB SSD", "Intel UHD 770", 4399.99, "https://www.emag.ro/sistem-all-in-one-hp-proone-440-g9-cu-procesor-intelr-coretm-i7-13700t-pana-la-4-9ghz-23-8-full-hd-ips-16gb-ddr4-512gb-ssd-intelr-uhd-graphics-770-freedos-black-884a0ea/pd/D8KK49YBM/"));
	pcs.add(new PC("Office Master", "office", "AMD Ryzen 5 2400G", 16, "1000GB SSD", "Radeon Vega11", 1899.99, "https://www.bing.com/search?q=AMD+Ryzen+5+2400g+specifications&FORM=R5FD")); 
	pcs.add(new PC("Diaxxa i5-12600K", "office", "Intel i5-12600K", 16, "512GB SSD", "Intel UHD 770", 2199.00, "https://www.systemtreff.de/Office-PC-Intel-Core-i5-12600K-16GB-3200MHz-Ram-Intel-UHD-Graphics-770-512GB-M2-NVMe")); 
	pcs.add(new PC("Myria Digital 38", "gaming_entry", "Intel Core i3-13100F", 16, "512GB SSD", "AMD Radeon RX 550", 2249.90, "https://www.smart.md/ro/sistem-desktop-gaming-myria-digital-38-powered-by-asus-intel-core-i3-13100f-pana-la-45ghz-16gb-ssd-512gb-amd-radeon-rx-550-4gb-ubuntu"));
	pcs.add(new PC("Myria Style V87", "gaming_entry", "AMD Ryzen 5 7600", 16, "500GB SSD", "NVIDIA GTX 1650", 3499.99, "https://altex.ro/sistem-desktop-gaming-myria-style-v87-powered-by-asus-amd-ryzen-5-7600-pana-la-5-2ghz-16gb-ssd-500gb-nvidia-geforce-gtx-1650-4gb-ubuntu/cpd/CLCMYRSTYLEV87/"));
	pcs.add(new PC("Lenovo LOQ 17IRR9", "gaming_mid", "Intel Core i7-14700F", 16, "1TB SSD", "NVIDIA RTX 4060", 6299.99, "https://www.itgalaxy.ro/desktop-pc/lenovo/loq-17irr9-intel-core-i7-14700f-16gb-ddr5-1tb-ssd-nvidia-geforce-rtx-4060-ti-8gb-black-720548/#:~:text=Desktop%20Gaming%20Lenovo%20LOQ%20Tower%2017IRR9%20%2C%20Intel%C2%AE,UDIMM%20slots%2C%20dual-channel%20capable%2C%20Up%20to%2032GB%20DDR5-560"));
	pcs.add(new PC("ASUS G13CHR", "gaming_mid", "Intel Core i7-14700", 16, "1TB SSD", "NVIDIA RTX 4060", 9499.99, "https://www.emag.ro/sistem-desktop-pc-gaming-asus-g13chr-cu-procesor-intelr-coretm-i7-14700-pana-la-5-30-ghz-32gb-ddr5-1tb-ssd-nvidiar-geforce-rtxtm4060-dual-8gb-gddr6-no-os-extreme-dark-gray-3y-pur-g13chr-7147000070/pd/DQQGJ4YBM/"));
	pcs.add(new PC("Myria Creator V3W", "gaming_high", "Intel Core i9-14900F", 64, "2TB SSD", "NVIDIA RTX 4090", 22499.99, "https://altex.ro/sistem-desktop-pc-myria-creator-v3w-powered-by-asus-intel-core-i9-14900f-pana-la-5-8ghz-64gb-ssd-2tb-nvidia-geforce-rtx-4090-24gb-windows-11-home/cpd/CLCMYRCREAT3W/")); 
	pcs.add(new PC("Acer ConceptD 500", "design", "Intel Core i9 12th Gen", 128, "4TB SSD", "NVIDIA RTX A4000", 4500.40, "https://www.windowscentral.com/acer-updates-conceptd-laptops-and-desktops-12th-gen-intel-chips-and-nvidia-rtx-graphics"));
	pcs.add(new PC("Dell Precision 3660", "design", "Intel Core i7 12th Gen", 16, "512GB SSD", "NVIDIA RTX A2000", 6087.99, "https://icecat.biz/en/p/dell/pynpc/precision-pcs-workstations-5397184759899-3660-100707745.html"));
	pcs.add(new PC("Lenovo Legion Tower 5i Gen 8", "design", "Intel Core i7 13th Gen", 16, "512GB SSD + 1TB HDD", "NVIDIA RTX 3060", 3736.74, "https://www.pcmag.com/reviews/lenovo-legion-tower-5i-gen-8-2024#:~:text=Lenovo%27s%20Legion%20Tower%205i%20is%20a%20sweet-looking%2C%20reasonably,and%20delivers%20reliable%20performance%20at%20an%20accessible%20price."));
	pcs.add(new PC("Apple Mac Studio M2 Ultra", "design", "Apple M2 Ultra", 64, "1TB SSD", "Integrated GPU 60 cores", 2086.22, "https://www.lifewire.com/apple-15-inch-macbook-air-macs-studio-pro-7511497"));
	pcs.add(new PC("HP ENVY 34-c0050", "design", "Intel Core i7-11700", 32, "1TB SSD", "NVIDIA RTX 3060", 26389.93, "https://www.amazon.eg/-/en/HP-Generation-i7-11700-Processor-34-c0050/dp/B09H3NHGGH#:~:text=Buy%20HP%20Envy%2034%20inch%20All-in-One%20Desktop%2C%2011th,Free%20Returns%20%E2%9C%93Cash%20on%20Delivery%20available%20on%20elig")); 
	pcs.add(new PC("HPE ProLiant DL20", "server", "Intel Xeon E-2436", 32, "960GB SSD", "None", 12078.31, "https://www.itstoc.ro/en/refurbished-servers/8036094-hp-proliant-dl360-g9-4-lff-2-x-octa-12-xeon-e5-2680-v3-25-ghz-32-gb-ddr4-ram-smartarray-p440ar-2-x-500w.html?msclkid=242337668ec11471bd5e5090912b6dd")); 
	pcs.add(new PC("Dell PowerEdge T150", "server", "Intel Xeon E-2378", 64, "2TB HDD + 960GB SSD", "None", 14936.23, "https://www.dell.com/en-uk/shop/dell-servers-storage-networking/smart-selection-poweredge-t150-tower-server/spd/poweredge-t150/pet1501a?msockid=3e944eec327566240d255fbc367560a8"));
	pcs.add(new PC("Dell PowerEdge R360", "server", "Intel Xeon E-2434", 16, "600GB HDD", "None", 10646.18, "https://www.servermania.com/dedicated-servers/24-cores/2x-intel-xeon-silver-4214r?utm_source=Bing&utm_medium=PPC&utm_campaign=Global%20%7C%20Single%20CPU%20and%20Product%20Categories&utm_content=2X%20INTEL%20XEON%20SILVER%204214R&utm_term=kwd-82052296036467&wickedsource=google&wickedid=&wickedid=&wcid=687875685&wv=4&&&msclkid=5982293afc931f66f40e4eccdc0b4a93"));

    }
    
//pc cu un processor bun si pret mai mic decat 3000
    public static List<PC> getAffordableEfficientPCs() {
        List<String> goodProcessors = Arrays.asList("Intel i5-12600K", "AMD Ryzen 5 7600", "Intel Core i3-13100F");
        List<PC> results = new ArrayList<>();
        for (PC pc : pcs) {
            if (goodProcessors.contains(pc.processor) && pc.price > 0 && pc.price <= 3000) {
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
            if ("design".equals(pc.category) && pc.ram >= 16 && goodGPUs.contains(pc.gpu) && pc.price > 0 && pc.price <= 6000) {
                results.add(pc);
            }
        }
        return results;
    }

//cel mai bun pc in functie de un buget   
    public static PC getBestSystemForBudget(double budget) {
        PC bestPC = null;
        for (PC pc : pcs) {
            if (pc.price > 0 && pc.price <= budget) {
                if (bestPC == null || pc.price > bestPC.price) {
                    bestPC = pc;
                }
            }
        }
        return bestPC;
    }

    public static void main(String[] args) {
    System.out.println("Affordable and efficient PCs:");
    for (PC pc : getAffordableEfficientPCs()) {
        System.out.println(pc.name + " - " + pc.link);
    }
        
        System.out.println("\nAffordable video editing PCs:");
    for (PC pc : getAffordableVideoEditingPCs()) {
        System.out.println(pc.name + " - " + pc.link);
    }
        
        double budget = 5000;
    PC bestPC = getBestSystemForBudget(budget);
    System.out.println("\nBest PC under " + budget + " Lei:");
    if (bestPC != null) {
        System.out.println(bestPC.name + " - " + bestPC.price + " Lei - " + bestPC.link);
    } else {
        System.out.println("No PC found within budget.");
    }
        
       
    }
}
