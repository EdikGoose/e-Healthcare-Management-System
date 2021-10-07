package innopolis.university.users.staff;

import innopolis.university.users.Patient;

public class AdultDepartmentDoctor extends Doctor {

    @Override
    public void treat(Patient patient, Nurse nurse) {
        System.out.println("Adult nurse" + this.getName() + "treated" + patient.getName() + "with 1 adult-pill.");

        nurse.treat(patient);
    }

    public AdultDepartmentDoctor(String name, String login, String password) {
        super(name, login, password);
    }
}
