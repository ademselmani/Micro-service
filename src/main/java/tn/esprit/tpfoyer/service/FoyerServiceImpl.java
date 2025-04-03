package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{

    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    public List<Foyer> getAllFoyer(){
        return foyerRepository.findAll();
    }

    public Foyer getFoyerById(Long id){
        return foyerRepository.findById(id).get();
    }

    public Foyer addFoyer(Foyer foyer){
        return foyerRepository.save(foyer);
    }

    public Foyer updateFoyer(Foyer foyer){
        return foyerRepository.save(foyer);
    }

    public void deleteFoyerById(Long id){
        foyerRepository.deleteById(id);
    }

    public Foyer addFoyerAndBlocAndAssign(Foyer foyer){
        return foyerRepository.save(foyer);
    }

    public void assignBlocToFoyer(Long foyerId, Long blocId){
        Foyer foyer = foyerRepository.findById(foyerId).get();
        Bloc bloc = blocRepository.findById(blocId).get();
        foyer.getBlocs().add(bloc);
        foyerRepository.save(foyer);
    }

    public void desassignBlocFromFoyer(Long foyerId, Long blocId){
        Foyer foyer = foyerRepository.findById(foyerId).get();
        Bloc bloc = blocRepository.findById(blocId).get();
        foyer.getBlocs().remove(bloc);
        foyerRepository.save(foyer);
    }



}
