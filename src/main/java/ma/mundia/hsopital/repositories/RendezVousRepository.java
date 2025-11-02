package ma.mundia.hsopital.repositories;

import ma.mundia.hsopital.entities.Medecin;
import ma.mundia.hsopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long >{
}
