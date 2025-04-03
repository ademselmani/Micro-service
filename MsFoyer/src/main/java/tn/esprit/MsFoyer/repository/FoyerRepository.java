package tn.esprit.MsFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.MsFoyer.entity.Foyer;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
