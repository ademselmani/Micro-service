package com.example.chombre.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.chombre.entity.Chombre;
import com.example.chombre.service.IChombreService;

import java.util.List;

@Tag(name="Gestion de chombre")
@RestController
@RequestMapping("/chombre")
public class ChombreRestController {

    @Autowired
    private IChombreService chombreService;

    // http://localhost:8089/tpfoyer/chombre/get-all-chombres
    @Operation(description="recuperer toutes les chombres de bd")
    @GetMapping("/get-all-chombres")
    public List<Chombre> getChombres() {
        List<Chombre> listChombres = chombreService.getAllChombres();
        return listChombres;
    }

    // http://localhost:8089/tpfoyer/chombre/get-chombre/8
    @Operation(description="recuperer les chombres by id")
    @GetMapping("/get-chombre/{chid}")
    public Chombre getChombre(@PathVariable("chid") Long chId) {
        Chombre chombre = chombreService.getChombreById(chId);
        return chombre;
    }

    // http://localhost:8089/tpfoyer/chombre/add-chombre
    @Operation(description="ajouter des chombres ")
    @PostMapping("/add-chombre")
    public Chombre addChombre(@RequestBody Chombre c) {
        Chombre chombre = chombreService.addChombre(c);
        return chombre;
    }

    // http://localhost:8089/tpfoyer/chombre/remove-chombre/{chid}
    @Operation(description="supprimer les chombres by id ")
    @DeleteMapping("/remove-chombre/{chid}")
    public void removeChombre(@PathVariable("chid") Long chId) {
        chombreService.removeChombreById(chId);
    }

    // http://localhost:8089/tpfoyer/chombre/update-chombre
    @Operation(description="modifier les chombres ")
    @PutMapping("/update-chombre")
    public Chombre updateChombre(@RequestBody Chombre c) {
        Chombre chombre = chombreService.updateChombre(c);
        return chombre;
    }

  /*  // http://localhost:8089/tpfoyer/chombre/get-chombre-by-etudiant-cin/12345678
    @Operation(description="Trouver la chombre d'un étudiant donné par son CIN")
    @GetMapping("/get-chombre-by-etudiant-cin/{cin}")
    public Chombre getChombreByEtudiantCin(@PathVariable("cin") Long cin) {
        return chombreService.findChombreByEtudiantCin(cin);
    }*/
}
