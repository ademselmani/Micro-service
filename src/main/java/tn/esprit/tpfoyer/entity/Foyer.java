package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@Table(name="FOYER")
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    @Column(name="NOM_FOYER")
    private String nomFoyer;

    @Column(name="CAPACITE_FOYER")
    private Long capaciteFoyer;

    @OneToOne(mappedBy="foyer")
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer", fetch = FetchType.EAGER)
    private Set<Bloc> blocs= new HashSet<Bloc>();
}
