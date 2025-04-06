package com.example.chombre.service;

import com.example.chombre.entity.Chombre;
import com.example.chombre.repository.ChombreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChombreServiceImpl implements IChombreService{

    @Autowired
    private ChombreRepository chombreRepository;

    public List<Chombre> getAllChombres(){
        return chombreRepository.findAll();
    }

    public Chombre getChombreById(Long chid){
        return chombreRepository.findById(chid).orElse(null);
    }

    public Chombre addChombre(Chombre c){
        return chombreRepository.save(c);
    }

    public void removeChombreById (Long chId){
        chombreRepository.deleteById(chId);
    }

    public Chombre updateChombre(Chombre c){
        return chombreRepository.save(c);
    }
}
