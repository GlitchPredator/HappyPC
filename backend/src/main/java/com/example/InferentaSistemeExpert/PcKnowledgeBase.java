package com.example.InferentaSistemeExpert;

import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class PcKnowledgeBase {
    public static List<PC> pcs = new ArrayList<>();

    private static final String GET_URL = "https://apex.oracle.com/pls/apex/fineas_mesesan/api/database/answers/answers";

    public static void sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray items = jsonResponse.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);

                String name = item.getString("name");
                String category = item.getString("category");
                String processor = item.getString("processor");
                int ram = item.getInt("ram");
                String storage = item.getString("storage");
                String gpu = item.getString("gpu");
                double price = item.getDouble("price");
                String link = item.getString("url");

                pcs.add(new PC(name, category, processor, ram, storage, gpu, price, link));
            }

            System.out.println("Added " + items.length() + " PCs from GET response.");
        } else {
            System.out.println("GET request did not work.");
        }
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

    public static void main(String[] args) throws IOException {
        sendGET();

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
