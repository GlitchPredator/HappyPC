package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ServiceInference;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;
import org.springframework.stereotype.Service;
import com.example.InferentaSistemeExpert.PcKnowledgeBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



@Service
public class PCConfigurationInference {

    //Metoda care gaseste PC-urile potrivite in functie de parametrii
    public String BackwardChaining(String name, String category, int ram, String storage, double price) throws IOException{

        sendGET() ;
        for (PC pc : PcKnowledgeBase.pcs) {
            if ((pc.getName().contains("ASUS") || pc.getName().contains("Myria") || pc.getName().contains("Lenovo")) && pc.getCategory().equals(category) && checkCharacteristics(pc, ram, storage, price)) {
                return "PC recomandat: " + pc.getName() + " " + pc.getProcessor() + " " + pc.getRam() + " " + pc.getStorage() + " " + pc.getGpu() + " " + pc.getPrice();
            }
        }

        return "Nu s-a gasit niciun PC recomandat!";
    }

    private final String GET_URL = "https://apex.oracle.com/pls/apex/fineas_mesesan/api/database/answers/answers";

    private void sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request did not work.");
        }
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
