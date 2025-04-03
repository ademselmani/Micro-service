package tn.esprit.tpfoyer.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;


@Tag(name="gestion de foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    IFoyerService foyerService;

    // http://localhost:8089/tpfoyer/foyer/get-all-foyers
    @Operation(description="recuperer toutes les foyers de bd")
    @GetMapping("/get-all-foyers")
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyer();
    }

    // http://localhost:8089/tpfoyer/foyer/get-foyer/1
    @Operation(description="recuperer les foyers by id")
    @GetMapping("/get-foyer/{foyerID}")
    public Foyer getFoyerById(@PathVariable Long foyerID) {
        return foyerService.getFoyerById(foyerID);
    }

    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @Operation(description="ajouter des foyers ")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    // http://localhost:8089/tpfoyer/foyer/update-foyer
    @Operation(description="modifier des foyers ")
    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    // http://localhost:8089/tpfoyer/foyer/delete-foyer/1
    @Operation(description="supprimer des foyers ")
    @DeleteMapping("/delete-foyer/{foyerID}")
    public void deleteFoyer(@PathVariable Long foyerID) {
        foyerService.deleteFoyerById(foyerID);
    }

    // http://localhost:8089/tpfoyer/foyer/add-foyer-and-bloc
    @PostMapping("/add-foyer-and-bloc")
    public Foyer addFoyerAndBlocAndAssign(@RequestBody Foyer foyer) {
        return foyerService.addFoyerAndBlocAndAssign(foyer);
    }

    // http://localhost:8089/tpfoyer/foyer/assign-foyer-to-bloc/1/1
    @PutMapping("/assign-foyer-to-bloc/{foyerId}/{blocId}")
    public void assignBlocToFoyer(@PathVariable("foyerId") Long foyerId,
                                  @PathVariable("blocId") Long blocId){
        foyerService.assignBlocToFoyer(foyerId, blocId);
    }

    // http://localhost:8089/tpfoyer/foyer/desassign-bloc-from-foyer/1/1
    @PutMapping("/desassign-bloc-from-foyer/{foyerId}/{blocId}")
    public void desassignBlocFromFoyer(@PathVariable("foyerId") Long foyerId,
                                       @PathVariable("blocId") Long blocId) {
        foyerService.desassignBlocFromFoyer(foyerId, blocId);
    }
}
