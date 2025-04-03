package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name="UNIVERSITE")
@AllArgsConstructor
@NoArgsConstructor
public class Universite {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    @Column(name="NOM_UNIVERSITE")
    private String nomUniversite;

    @Column(name="ADRESSE")
    private String adresse;

    @OneToOne
    private Foyer foyer;
}
