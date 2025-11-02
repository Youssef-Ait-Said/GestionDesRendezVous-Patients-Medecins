package ma.mundia.hsopital.repositories;

import ma.mundia.hsopital.entities.Consultation;
import ma.mundia.hsopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Console;

public interface consulationRepository extends JpaRepository<Consultation, Long >{

}
