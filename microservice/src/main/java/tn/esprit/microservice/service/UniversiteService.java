package tn.esprit.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.microservice.entity.Universite;
import tn.esprit.microservice.repository.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService {

    private final UniversiteRepository universiteRepository;

    @Autowired
    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    // Récupérer toutes les universités
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    // Récupérer une université par son id
    public Optional<Universite> getUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    // Ajouter une université
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    // Mettre à jour une université
    public Universite updateUniversite(Long id, Universite universite) {
        if (universiteRepository.existsById(id)) {
            universite.setId(id);
            return universiteRepository.save(universite);
        } else {
            return null;
        }
    }

    // Supprimer une université
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    // Filtrer les universités par adresse
    public List<Universite> getUniversitesByAddress(String address) {
        return universiteRepository.findByAdresseContainingIgnoreCase(address);
    }
}
