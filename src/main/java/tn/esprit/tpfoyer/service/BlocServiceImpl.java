package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImpl implements IBlocService {

    BlocRepository blocRepository;

    @Scheduled(fixedRate = 120000) // Toutes les 2 minutes
    public void scheduleGetUnassignedBlocs() {
        List<Bloc> unassignedBlocs = getUnassignedBlocs();
        log.info("Nombre de blocs non affectés : {}", unassignedBlocs.size());
        for (Bloc bloc : unassignedBlocs) {
            log.info("Bloc non affecté : {}", bloc);
        }
    }
    public List<Bloc> getUnassignedBlocs() {
        return blocRepository.findByFoyerIsNull();
    }



    public List<Bloc> getAllBlocs(){
        return blocRepository.findAll();
    }

    public Bloc getBlocById(Long blocId){
        return blocRepository.findById(blocId).get();
    }

    public Bloc addBloc(Bloc bloc){
        return blocRepository.save(bloc);
    }

    public Bloc updateBloc(Bloc bloc){
        return blocRepository.save(bloc);
    }

    public void deleteBlocById(Long blocId){
        blocRepository.deleteById(blocId);
    }
}
