package com.example.chombre.service;

import com.example.chombre.entity.Rating;
import com.example.chombre.entity.Chombre;
import java.util.List;

public interface RatingService {
    Rating addRating(Long chombreId, Rating rating);
    List<Rating> getChombreRatings(Long chombreId);
    Double getAverageRating(Long chombreId);
    List<Rating> getRecentRatings(Long chombreId);
    void deleteRating(Long ratingId);
} 