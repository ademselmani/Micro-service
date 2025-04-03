package tn.esprit.tpfoyer.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name="BLOC")
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    @Column(name="NOM_BLOC")
    private String nomBloc;

    @Column(name="CAPACITE_BLOC")
    private String capaciteBloc;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Foyer foyer;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> chambres;

    @Override
    public String toString() {
        return "Bloc{" +
                "id=" + idBloc +
                ", nomBloc='" + nomBloc + '\'' +
                ", capaciteBloc=" + capaciteBloc +
                ", foyer=" + (foyer != null ? foyer.getNomFoyer() : "null") +
                '}';
    }
}
