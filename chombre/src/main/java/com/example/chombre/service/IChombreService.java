package com.example.chombre.service;
import com.example.chombre.entity.Chombre;
import java.util.*;

public interface IChombreService {

    public List<Chombre> getAllChombres();
    public Chombre getChombreById(Long chId);
    public Chombre addChombre(Chombre c);
    public void removeChombreById (Long chId);
    public Chombre updateChombre(Chombre c);

    // Removed the method as it is no longer needed
    // Chombre findChombreByEtudiantCin(Long cin);
}
