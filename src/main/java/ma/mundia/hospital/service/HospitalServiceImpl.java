package ma.mundia.hospital.service;

import jakarta.transaction.Transactional;
import ma.mundia.hospital.entities.Consultation;
import ma.mundia.hospital.entities.Medecin;
import ma.mundia.hospital.entities.Patient;
import ma.mundia.hospital.entities.RendezVous;
import ma.mundia.hospital.repositories.ConsulationRepository;
import ma.mundia.hospital.repositories.MedecinRepository;
import ma.mundia.hospital.repositories.PatientRepository;
import ma.mundia.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsulationRepository consultationRepository;

    public HospitalServiceImpl(ConsulationRepository consultationRepository,
                               PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository) {

        this.consultationRepository = consultationRepository;
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient findByName(String name) {
        return patientRepository.findByName(name);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinByName(String name) {
        return medecinRepository.findByName(name);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
