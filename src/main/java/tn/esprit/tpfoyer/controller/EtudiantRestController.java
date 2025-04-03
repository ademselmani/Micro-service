package tn.esprit.tpfoyer.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;
import java.util.List;

@Tag(name="Gestion d'etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

    IEtudiantService etudiantService;

    // http://localhost:8089/tpfoyer/etudiant/get-all-etudiants
    @Operation(description="recuperer toutes les etudiants de bd")
    @GetMapping("/get-all-etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // http://localhost:8089/tpfoyer/etudiant/get-etudiant/1
    @Operation(description="recuperer les etudiants by id")
    @GetMapping("/get-etudiant/{EtId}")
    public Etudiant getEtudiant(@PathVariable Long EtId) {
        return etudiantService.getEtudiantById(EtId);
    }

    // http://localhost:8089/tpfoyer/etudiant/update-etudiant
    @Operation(description="modifier toutes les etudiants de bd")
    @PostMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @Operation(description="ajouter des etudiants")
    @PutMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    // http://localhost:8089/tpfoyer/etudiant/delete-etudiant/1
    @Operation(description="supprimer les etudiants by id")
    @DeleteMapping("/delete-etudiant/{EtId}")
    public void deleteEtudiantById(@PathVariable Long EtId) {
        etudiantService.deleteEtudiantById(EtId);
    }


}
