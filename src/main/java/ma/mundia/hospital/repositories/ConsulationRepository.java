package ma.mundia.hospital.repositories;

import ma.mundia.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsulationRepository extends JpaRepository<Consultation, Long >{
}
