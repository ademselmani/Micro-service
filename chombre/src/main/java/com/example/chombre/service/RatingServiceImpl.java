package com.example.chombre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.chombre.entity.Rating;
import com.example.chombre.entity.Chombre;
import com.example.chombre.repository.RatingRepository;
import com.example.chombre.repository.ChombreRepository;

import java.util.Date;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ChombreRepository chombreRepository;

    @Override
    public Rating addRating(Long chombreId, Rating rating) {
        if (rating.getScore() < 1 || rating.getScore() > 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating score must be between 1 and 5");
        }

        Chombre chombre = chombreRepository.findById(chombreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chombre with ID " + chombreId + " not found. Please create the chombre first."
                ));

        rating.setChombre(chombre);
        rating.setRatingDate(new Date());

        // Update chombre's average rating
        Double currentAvg = chombre.getAverageRating();
        Integer totalRatings = chombre.getTotalRatings();
        
        Double newAvg = ((currentAvg * totalRatings) + rating.getScore()) / (totalRatings + 1);
        
        chombre.setAverageRating(newAvg);
        chombre.setTotalRatings(totalRatings + 1);
        
        chombreRepository.save(chombre);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getChombreRatings(Long chombreId) {
        Chombre chombre = chombreRepository.findById(chombreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chombre with ID " + chombreId + " not found"
                ));
        return ratingRepository.findByChombre(chombre);
    }

    @Override
    public Double getAverageRating(Long chombreId) {
        Chombre chombre = chombreRepository.findById(chombreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chombre with ID " + chombreId + " not found"
                ));
        return chombre.getAverageRating();
    }

    @Override
    public List<Rating> getRecentRatings(Long chombreId) {
        Chombre chombre = chombreRepository.findById(chombreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chombre with ID " + chombreId + " not found"
                ));
        return ratingRepository.findByChombreOrderByRatingDateDesc(chombre);
    }

    @Override
    public void deleteRating(Long ratingId) {
        Rating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Rating with ID " + ratingId + " not found"
                ));
        
        Chombre chombre = rating.getChombre();
        Integer totalRatings = chombre.getTotalRatings();
        
        if (totalRatings > 1) {
            Double currentAvg = chombre.getAverageRating();
            Double newAvg = ((currentAvg * totalRatings) - rating.getScore()) / (totalRatings - 1);
            chombre.setAverageRating(newAvg);
        } else {
            chombre.setAverageRating(0.0);
        }
        
        chombre.setTotalRatings(totalRatings - 1);
        chombreRepository.save(chombre);
        ratingRepository.deleteById(ratingId);
    }
} 