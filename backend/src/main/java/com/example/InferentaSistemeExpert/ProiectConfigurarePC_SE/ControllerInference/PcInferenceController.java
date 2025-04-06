package com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ControllerInference;


import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.PC.PC;
import com.example.InferentaSistemeExpert.ProiectConfigurarePC_SE.ServiceInference.PCConfigurationInference;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/api/inference")
public class PcInferenceController {

    private final PCConfigurationInference inferenceService;

    public PcInferenceController(PCConfigurationInference inferenceService) {
        this.inferenceService = inferenceService;
    }

    @PostMapping("/response")
    public ResponseEntity<PC> findPC(@RequestParam String name, @RequestParam String category, @RequestParam String processor, @RequestParam int ram, @RequestParam String storage, @RequestParam String gpu, @RequestParam double price) {
        boolean result = inferenceService.BackwardChaining(name, category, processor, ram, storage, gpu, price);
        return result ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}