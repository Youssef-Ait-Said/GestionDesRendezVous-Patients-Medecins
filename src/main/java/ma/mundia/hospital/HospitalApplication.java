package ma.mundia.hospital;
import ma.mundia.hospital.entities.*;
import ma.mundia.hospital.repositories.ConsulationRepository;
import ma.mundia.hospital.repositories.MedecinRepository;
import ma.mundia.hospital.repositories.PatientRepository;
import ma.mundia.hospital.repositories.RendezVousRepository;
import ma.mundia.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService iHospitalService,
                            RendezVousRepository rendezVousRepository) {

        return args -> {
            Stream.of("Mohamed", "Najat", "Hassan", "Souad").
                    forEach(name ->{
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setMalade(false);
                        patient.setDateNaissance(new Date());
                        iHospitalService.savePatient(patient);
                    });
            Stream.of("Youssef", "Houssam", "Meriem").
                    forEach(name ->{
                       Medecin medecin = new Medecin();
                       medecin.setName(name);
                       medecin.setEmail(name.toLowerCase() + "@gmail.com");
                       medecin.setSpecialte(Math.random()>0.5?"Cardio" : "Dentiste");
                       iHospitalService.saveMedecin(medecin);
                    });

            Patient patient = iHospitalService.findById(1L);
            Patient patient1 = iHospitalService.findByName("Hassan");

            Medecin medecin = iHospitalService.findMedecinByName("Meriem");

            RendezVous rendezVous =  new RendezVous();
            rendezVous.setId(UUID.randomUUID().toString());
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            iHospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Ce rendez-vous est dédié a .....");
            iHospitalService.saveConsultation(consultation);

        };
    }

}
