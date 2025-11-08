package ma.mundia.hospital.repositories;

import ma.mundia.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long >{
    Medecin findByName(String name);

    String name(String name);
}
