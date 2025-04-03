package tn.esprit.tpfoyer.service;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    public List<Foyer> getAllFoyer();
    public Foyer getFoyerById(Long FoyerId);
    public Foyer addFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public void deleteFoyerById(Long FoyerId);

    public Foyer addFoyerAndBlocAndAssign(Foyer foyer);
    public void assignBlocToFoyer(Long foyerId, Long blocId);
    public void desassignBlocFromFoyer(Long foyerId, Long blocId);
}
