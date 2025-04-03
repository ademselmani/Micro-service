package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Getter
@Setter
@Table(name="CHAMBRE")
@AllArgsConstructor
@NoArgsConstructor

public class Chambre {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idChambre;

    @Column(name="NUMERO_CHAMBRE")
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE_CHAMBRE")
    private TypeChambre typeC;

    @ManyToOne
    Bloc bloc ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}

