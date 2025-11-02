package ma.mundia.hsopital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String specialte;
    @OneToMany(mappedBy = "medecin" , fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
