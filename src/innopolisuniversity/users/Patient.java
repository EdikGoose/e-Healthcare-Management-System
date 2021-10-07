package innopolisuniversity.users;

import innopolisuniversity.system.Registry;
import innopolisuniversity.system.data.PatientController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class represents the account of a patient
 */
public class Patient extends User {

    private final LocalDate birthDate;
    private boolean hospitalized;
    
    public Patient(String name, String login, String password, LocalDate birthDate) {
        super(name, login, password);
        this.birthDate = birthDate;
        this.hospitalized = false;
        this.id = PatientController.getInstance().getIdForNewEntity();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(boolean hospitalized) {
        this.hospitalized = hospitalized;
    }

    public boolean isAdult() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now()) > 18;
    }

    public void visitDoctor() {
        Registry.getInstance().makeAppointment(this);
    }


    @Override
    public int getId() {
        return PatientController.getInstance().getIdForNewEntity();
    }

    @Override
    public String toString() {
        return super.toString() + ". Birth date:" + birthDate + ". Is hospitalized: " + hospitalized;
    }
}
