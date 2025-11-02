package ma.mundia.hsopital.repositories;

import ma.mundia.hsopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long >{
}
