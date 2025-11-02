package ma.mundia.hsopital.repositories;

import ma.mundia.hsopital.entities.Medecin;
import ma.mundia.hsopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long >{
}
