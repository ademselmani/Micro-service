package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Getter
@Setter
@Table(name="RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @Column(name="ID_RESERVATION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name="ANNEE_UNIVERSITAIRE")
    private Date anneeUniversitaire;

    @Column(name="STATUS")
    private boolean estValid;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @Override
    public String toString() {
        return "Reservation [idReservation=" + idReservation + ", anneeUniversitaire=" + anneeUniversitaire + ", estValid=" + estValid + "]";
    }


}
