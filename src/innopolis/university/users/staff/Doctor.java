package innopolis.university.users.staff;

import innopolis.university.system.Registry;
import innopolis.university.system.Report;
import innopolis.university.system.data.DoctorController;
import innopolis.university.system.data.NurseController;
import innopolis.university.users.Patient;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Doctor extends Staff {

    public abstract void treat(Patient patient, Nurse nurse);

    protected Doctor(String name, String login, String password) {
        super(name, login, password);
        this.id = DoctorController.getInstance().getIdForNewEntity();
    }

    public void conductExam() {
        Random rand = new Random();

        LinkedList<Patient> hospitalizedPatients = (LinkedList<Patient>) Registry.getInstance().getHospitalizedPatients();
        LinkedList<Nurse> nurses = (LinkedList<Nurse>) NurseController.getInstance().getAll();

        for (Patient patient: hospitalizedPatients) {
            Nurse nurse = nurses.get(rand.nextInt(nurses.size())); // get random nurse

            // cure patients. The way of curation depends on the kind of doctor (Abstract Factory)
            treat(patient, nurse);

            // 50% chance for a patient to get discharged from the hospital
            if(rand.nextInt(100) < 50) {
                Registry.getInstance().dischargePatient(patient);
            }
        }
    }

    public boolean checkIfHospitalized(Patient patient) {
        LinkedList<Patient> HospitalizedPatients = (LinkedList<Patient>) Registry.getInstance().getHospitalizedPatients();
        return HospitalizedPatients.contains(patient);
    }

    /**
     * Hospitalize patient if they are ill
     * @param patient is a patient which doctor checks if they are ill
     * @return {@code true} if patient is ill and has been hospitalized
     *      {@code false} if patient is NOT ill and has NOT been hospitalized
     */
    public boolean hospitalizeIfIll(Patient patient) {
        Random rand = new Random();
        if (rand.nextInt(100) < 50) {
            Registry.getInstance().hospitalizePatient(patient);
            return true;
        }
        return false; // patient has not been hospitalized
    }

    public List<Report> getReports() {
        return Registry.getInstance().getReportsWithDoctor(this);
    }


    @Override
    public int getId() {
        return DoctorController.getInstance().getIdForNewEntity();
    }
}
