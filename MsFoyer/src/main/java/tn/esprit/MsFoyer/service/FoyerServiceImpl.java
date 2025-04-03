package tn.esprit.MsFoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.MsFoyer.entity.Foyer;
import tn.esprit.MsFoyer.repository.FoyerRepository;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {
    @Autowired
    FoyerRepository foyerRepository;

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

    public void deleteFoyerById(Long id){ foyerRepository.deleteById(id);}

    public String getCapacityStatus(Long foyerId) {
        Foyer foyer = foyerRepository.findById(foyerId).orElseThrow(() -> new RuntimeException("Foyer not found"));
        return foyer.getCapacityStatus();
    }




}
