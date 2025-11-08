package ma.mundia.hospital;
import ma.mundia.hospital.entities.*;
import ma.mundia.hospital.repositories.ConsulationRepository;
import ma.mundia.hospital.repositories.MedecinRepository;
import ma.mundia.hospital.repositories.PatientRepository;
import ma.mundia.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsulationRepository consulationRepository) {

        return args -> {
            Stream.of("Mohamed", "Najat", "Hassan", "Souad").
                    forEach(name ->{
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setMalade(false);
                        patient.setDateNaissance(new Date());
                        patientRepository.save(patient);
                    });
            Stream.of("Youssef", "Houssam", "Meriem").
                    forEach(name ->{
                       Medecin medecin = new Medecin();
                       medecin.setName(name);
                       medecin.setEmail(name.toLowerCase() + "@gmail.com");
                       medecin.setSpecialte(Math.random()>0.5?"Cardio" : "Dentiste");
                       medecinRepository.save(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByName("Hassan");

            Medecin medecin = medecinRepository.findByName("Meriem");

            RendezVous rendezVous =  new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVousRepository.save(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("Ca sera demain");
            consultation.setRendezVous(rendezVous);
            consulationRepository.save(consultation);

        };
    }

}
