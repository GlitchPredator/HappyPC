<<<<<<< HEAD
package com.example.ProiectConfigurarePC_SE.ControllerInference;
=======
package src.main.java.com.example.ProiectConfigurarePC_SE.ControllerInference;
>>>>>>> 3957b83 (Add maven dependencies)

import com.example.ProiectConfigurarePC_SE.PC.PC;
import com.example.ProiectConfigurarePC_SE.ServiceInference.PCConfigurationInference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inference")
public class PcInferenceController {

    private final PCConfigurationInference inferenceService;

    public PcInferenceController(PCConfigurationInference inferenceService) {
        this.inferenceService = inferenceService;
    }

    @PostMapping("/find")
<<<<<<< HEAD
    public ResponseEntity<PC> findPC(@RequestParam String name, @RequestParam String category, @RequestParam String processor, @RequestParam int ram, @RequestParam String storage, @RequestParam String gpu, @RequestParam double price) {
        boolean result = inferenceService.BackwardChaining(name, category, processor, ram, storage, gpu, price);
=======
    public ResponseEntity<PC> findPC(@RequestParam String type, @RequestParam double price, @RequestParam int resolution, @RequestParam double battery, @RequestParam double performance) {
        boolean result = inferenceService.BackwardChaining(type, price, resolution, battery, performance);
>>>>>>> 3957b83 (Add maven dependencies)
        return result ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}