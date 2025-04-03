package tn.esprit.tpfoyer.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{

    ChambreRepository chambreRepository;

    public List<Chambre> getAllChambres(){
        return chambreRepository.findAll();
    }

    public Chambre getChambreById(Long chid){
        return chambreRepository.findById(chid).get();
    }

    public Chambre addChambre(Chambre c){
        return chambreRepository.save(c);
    }

    public void removeChambreById (Long chId){
        chambreRepository.deleteById(chId);
    }

    public Chambre updateChambre(Chambre c){
        return chambreRepository.save(c);
    }
    public Chambre findChambreByEtudiantCin(Long cin) {
        return chambreRepository.findChambreByEtudiantCin(cin);
    }


}
