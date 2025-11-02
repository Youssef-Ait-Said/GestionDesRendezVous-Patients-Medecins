package ma.mundia.hsopital;

import ma.mundia.hsopital.entities.Patient;
import ma.mundia.hsopital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HsopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsopitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            Stream.of("Mohamed", "Najat", "Hassan", "Souad").
                    forEach(name ->{
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setMalade(false);
                        patient.setDateNaissance(new Date());
                        patientRepository.save(patient);
                    });
        };
    }

}
