package com.example.chombre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.chombre.entity.Rating;
import com.example.chombre.entity.Chombre;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByChombre(Chombre chombre);
    List<Rating> findByChombreOrderByRatingDateDesc(Chombre chombre);
    Double findAverageScoreByChombre(Chombre chombre);
} 