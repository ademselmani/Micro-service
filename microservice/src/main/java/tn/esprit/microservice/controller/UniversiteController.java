package tn.esprit.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microservice.entity.Universite;
import tn.esprit.microservice.entity.WeatherResponse;
import tn.esprit.microservice.service.UniversiteService;
import tn.esprit.microservice.service.WeatherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universites")
public class UniversiteController {

    private final UniversiteService universiteService;

    private final WeatherService weatherService; // Assurez-vous d'injecter le service météo

    public UniversiteController(UniversiteService universiteService, WeatherService weatherService) {
        this.universiteService = universiteService;
        this.weatherService = weatherService; // Assurez-vous d'initialiser le service météo correctement
    }

    
    @GetMapping("/all")
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @GetMapping("/search/{id}")
    public Optional<Universite> getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        return universiteService.updateUniversite(id, universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    // Nouveau point de terminaison pour filtrer par adresse
    @GetMapping("/filter")
    public List<Universite> getUniversitesByAddress(@RequestParam String address) {
        return universiteService.getUniversitesByAddress(address);
    }
     // Route pour obtenir la météo d'une université en fonction de son adresse
     @GetMapping(value = "/{id}/weather", produces = MediaType.APPLICATION_JSON_VALUE)
     public @ResponseBody WeatherResponse getWeatherForUniversite(@PathVariable Long id) {
         // Récupérer l'université par ID
         Universite universite = universiteService.getUniversiteById(id)
                 .orElseThrow(() -> new RuntimeException("Université non trouvée"));
 
         // Utiliser l'adresse de l'université pour obtenir la météo
         return weatherService.getWeather(universite.getAdresse());
     }
}
