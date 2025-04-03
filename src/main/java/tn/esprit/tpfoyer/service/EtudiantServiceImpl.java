package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants(){
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long etudiantId){
        return etudiantRepository.findById(etudiantId).get();
    }

    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiantById(Long etudiantId){
        etudiantRepository.deleteById(etudiantId);
    }
}
