package ma.mundia.hospital.service;

import ma.mundia.hospital.entities.Consultation;
import ma.mundia.hospital.entities.Medecin;
import ma.mundia.hospital.entities.Patient;
import ma.mundia.hospital.entities.RendezVous;
import ma.mundia.hospital.repositories.ConsulationRepository;
import ma.mundia.hospital.repositories.MedecinRepository;
import ma.mundia.hospital.repositories.PatientRepository;
import ma.mundia.hospital.repositories.RendezVousRepository;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Patient findById(Long id);
     Patient findByName(String name);
     Medecin saveMedecin(Medecin medecin);
     Medecin findMedecinById(Long id);
     Medecin findMedecinByName(String name);
     RendezVous saveRendezVous(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
};
