package ma.mundia.hospital.repositories;

import ma.mundia.hospital.entities.RendezVous;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String >{

}
