package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {

    public List<Universite> gettAllUniversite();
    public Universite getUniversiteById(Long id);
    public Universite updateUniversite(Universite universite);
    public Universite addUniversite(Universite universite);
    public void deleteUniversiteById(Long id);

}
