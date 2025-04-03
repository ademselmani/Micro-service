package tn.esprit.tpfoyer.service;
import tn.esprit.tpfoyer.entity.Bloc;
import java.util.List;

public interface IBlocService {

    public List<Bloc> getAllBlocs();
    public Bloc getBlocById(Long blocId);
    public Bloc addBloc(Bloc bloc);
    public Bloc updateBloc(Bloc bloc);
    public void deleteBlocById(Long blocId);

    List<Bloc> getUnassignedBlocs();
}
