package com.example.chombre.entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="CHOMBRE")
public class Chombre {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idChombre;

    @Column(name="NUMERO_CHOMBRE")
    private Long numeroChombre;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE_CHOMBRE")
    private TypeChombre typeC;

    @Column(name="AVERAGE_RATING")
    private Double averageRating = 0.0;

    @Column(name="TOTAL_RATINGS")
    private Integer totalRatings = 0;

    @OneToMany(mappedBy = "chombre", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    public Chombre() {}

    public Long getIdChombre() {
        return idChombre;
    }

    public void setIdChombre(Long idChombre) {
        this.idChombre = idChombre;
    }

    public Long getNumeroChombre() {
        return numeroChombre;
    }

    public void setNumeroChombre(Long numeroChombre) {
        this.numeroChombre = numeroChombre;
    }

    public TypeChombre getTypeC() {
        return typeC;
    }

    public void setTypeC(TypeChombre typeC) {
        this.typeC = typeC;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
}

