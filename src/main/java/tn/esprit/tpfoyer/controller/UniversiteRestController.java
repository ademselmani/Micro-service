package tn.esprit.tpfoyer.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;

import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;


@Tag(name="gestion d'universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteService universiteService;

    // http://localhost:8089/tpfoyer/universite/get-all-universites
    @Operation(description="recuperer toutes les universites de bd")
    @GetMapping("/get-all-universites")
    public List<Universite> getAllUnivesite() {
        return universiteService.gettAllUniversite();
    }

    // http://localhost:8089/tpfoyer/universite/get-universite/1
    @Operation(description ="recuperer les universites by id")
    @GetMapping("/get-universite/{universiteId}")
    public Universite getUniversiteById(@PathVariable Long universiteId) {
        return universiteService.getUniversiteById(universiteId);
    }

    // http://localhost:8089/tpfoyer/universite/add-universite
    @Operation(description="ajoutter des universites ")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    // http://localhost:8089/tpfoyer/universite/update-universite
    @Operation(description="modifier des universites ")
    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    // http://localhost:8089/tpfoyer/universite/delete-universite/1
    @Operation(description="supprimer des universites by id")
    @PutMapping("/delete-universite/{universiteId}")
    public void deleteUniversite(@PathVariable Long universiteId) {
        universiteService.deleteUniversiteById(universiteId);
    }
}
