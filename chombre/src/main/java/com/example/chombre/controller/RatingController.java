package com.example.chombre.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.chombre.entity.Rating;
import com.example.chombre.service.RatingService;

import java.util.List;

@Tag(name = "Gestion des notes")
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Operation(description = "Ajouter une note pour une chombre")
    @PostMapping("/add/{chombreId}")
    public ResponseEntity<Rating> addRating(
            @PathVariable Long chombreId,
            @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.addRating(chombreId, rating));
    }

    @Operation(description = "Obtenir toutes les notes d'une chombre")
    @GetMapping("/chombre/{chombreId}")
    public ResponseEntity<List<Rating>> getChombreRatings(@PathVariable Long chombreId) {
        return ResponseEntity.ok(ratingService.getChombreRatings(chombreId));
    }

    @Operation(description = "Obtenir la note moyenne d'une chombre")
    @GetMapping("/average/{chombreId}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long chombreId) {
        return ResponseEntity.ok(ratingService.getAverageRating(chombreId));
    }

    @Operation(description = "Obtenir les notes récentes d'une chombre")
    @GetMapping("/recent/{chombreId}")
    public ResponseEntity<List<Rating>> getRecentRatings(@PathVariable Long chombreId) {
        return ResponseEntity.ok(ratingService.getRecentRatings(chombreId));
    }

    @Operation(description = "Supprimer une note")
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok().build();
    }
} 