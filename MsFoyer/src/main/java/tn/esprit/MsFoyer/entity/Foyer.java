package tn.esprit.MsFoyer.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="FOYER")
public class Foyer {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    @Column(name="nom_foyer")
    private String nomFoyer;

    @Column(name="capacite_foyer")
    private Long capaciteFoyer;

    @OneToOne(mappedBy="foyer")
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer", fetch = FetchType.EAGER)
    private Set<Bloc> blocs= new HashSet<Bloc>();

    @Transient
    public String getCapacityStatus() {
        if (capaciteFoyer == null) {
            return "Unknown Capacity"; // Handle null values gracefully
        }
        return capaciteFoyer > 100 ? "Large Capacity" : "Normal Capacity";
    }

}
