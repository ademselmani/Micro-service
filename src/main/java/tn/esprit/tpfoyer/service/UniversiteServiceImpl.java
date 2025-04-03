package tn.esprit.tpfoyer.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{

    UniversiteRepository universiteRepository;

    public List<Universite> gettAllUniversite(){
        return universiteRepository.findAll();
    }

    public Universite getUniversiteById(Long universiteId){
        return universiteRepository.findById(universiteId).get();
    }

    public Universite updateUniversite(Universite universite){
        return universiteRepository.save(universite);
    }

    public Universite addUniversite(Universite universite){
        return universiteRepository.save(universite);
    }

    public void deleteUniversiteById(Long universiteId){
        universiteRepository.deleteById(universiteId);
    }
}
