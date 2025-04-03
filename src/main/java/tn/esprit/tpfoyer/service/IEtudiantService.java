package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getAllEtudiants();
    public Etudiant getEtudiantById(Long etudiantId);
    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiantById(Long etudiantId);

}
