package tn.esprit.MsFoyer.service;


import tn.esprit.MsFoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    public List<Foyer> getAllFoyer();
    public Foyer getFoyerById(Long FoyerId);
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public void deleteFoyerById(Long FoyerId);

    public String getCapacityStatus(Long foyerID);

}
