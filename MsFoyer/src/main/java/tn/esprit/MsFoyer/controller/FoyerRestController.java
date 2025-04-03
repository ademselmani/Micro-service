package tn.esprit.MsFoyer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.MsFoyer.entity.Foyer;
import tn.esprit.MsFoyer.service.IFoyerService;

import java.util.List;



@RestController
//@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    @Autowired
    IFoyerService foyerService;

    // http://localhost:8089/microService/foyer
    @GetMapping("")
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyer();
    }

    // http://localhost:8089/microService/foyer/1
    @GetMapping("/{foyerID}")
    public Foyer getFoyerById(@PathVariable Long foyerID) {
        return foyerService.getFoyerById(foyerID);
    }

    // http://localhost:8089/microService/foyer
    @PostMapping("")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    // http://localhost:8089/microService/foyer
    @PutMapping("")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    // http://localhost:8089/microService/foyer/1
    @DeleteMapping("/{foyerID}")
    public void deleteFoyer(@PathVariable Long foyerID) {
        foyerService.deleteFoyerById(foyerID);
    }

    //http://localhost:8089/microService/foyer/capacity-status/1

    @GetMapping("/capacity-status/{foyerID}")
    public String getCapacityStatus(@PathVariable Long foyerID) {
        Foyer foyer = foyerService.getFoyerById(foyerID);
        return foyer.getCapacityStatus();
    }


}


