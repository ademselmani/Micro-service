package com.example.chombre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.chombre.entity.Chombre;

@Repository
public interface ChombreRepository extends JpaRepository<Chombre, Long> {
    // @Query("SELECT c FROM Chombre c JOIN c.reservations r JOIN r.etudiants e WHERE e.cin = :cin")
    // Chombre findChombreByEtudiantCin(@Param("cin") Long cin);
}
