package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Getter
@Setter
@Table(name="ETUDIANT")
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    @Column(name="NOM_ET")
    private String nomEt;

    @Column(name="PERNOM_ET")
    private String prenomEt;

    @Column(name="CIN")
    private Long cin;

    @Column(name="ECOLE")
    private String ecole;

    @Column(name="DATE_NAISSANCE")
    private Date dateNaissance;

    @ManyToMany(mappedBy="etudiants", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
