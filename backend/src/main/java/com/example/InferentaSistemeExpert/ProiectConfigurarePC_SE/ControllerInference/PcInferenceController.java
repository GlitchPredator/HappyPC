package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ControllerInference;


import com.example.InferentaSistemeExpert.PC_DTO.PC_DTO;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ServiceInference.PCConfigurationInference;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inference")
public class PcInferenceController {

    private final PCConfigurationInference inferenceService;

    public PcInferenceController(PCConfigurationInference inferenceService) {
        this.inferenceService = inferenceService;
    }

    @PostMapping("/answers")
    public ResponseEntity<String> recomandarePC(@RequestBody PC_DTO pcdto) throws IOException {
        String response = inferenceService.BackwardChaining(
                pcdto.getName(),
                pcdto.getCategory(),
                pcdto.getRam(),
                pcdto.getStorage(),
                pcdto.getPrice()
        );

        return ResponseEntity.ok(response);
    }
}