package tn.esprit.tpfoyer.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;
import java.util.List;

@Tag(name="Gestion bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/get-all-blocs
    @Operation(description =" recuperer toutes les blocs de db")
    @GetMapping("/get-all-blocs")
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    // http://localhost:8089/tpfoyer/bloc/get-bloc/2
    @Operation(description =" recuperer les blocs by id")
    @GetMapping("/get-bloc/{BlocId}")
    public Bloc getBloc(@PathVariable Long BlocId) {
        return blocService.getBlocById(BlocId);
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @Operation(description =" ajouter des blocs")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    // http://localhost:8089/tpfoyer/bloc/update-bloc
    @Operation(description =" modifier des blocs")
    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    // http://localhost:8089/tpfoyer/bloc/delete-bloc/1
    @Operation(description =" supprimer les blocs by id")
    @DeleteMapping("/delete-bloc/{blocId}")
    public void deleteBloc(@PathVariable Long blocId) {
        blocService.deleteBlocById(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/get-unassigned-blocs
    @GetMapping("/get-unassigned-blocs")
    public List<Bloc> getUnassignedBlocs() {
        return blocService.getUnassignedBlocs();
    }


}
