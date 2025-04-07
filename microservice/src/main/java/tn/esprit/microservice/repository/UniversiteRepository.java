package tn.esprit.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.microservice.entity.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    // Rechercher les universités par adresse (partiellement)
    List<Universite> findByAdresseContainingIgnoreCase(String adresse);
}
