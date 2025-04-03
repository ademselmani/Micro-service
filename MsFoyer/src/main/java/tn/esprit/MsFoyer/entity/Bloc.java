package tn.esprit.MsFoyer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="BLOC")
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

}
