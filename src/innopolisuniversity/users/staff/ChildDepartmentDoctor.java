package innopolisuniversity.users.staff;

import innopolisuniversity.users.Patient;

public class ChildDepartmentDoctor extends Doctor {

    @Override
    public void treat(Patient patient, Nurse nurse) {
        System.out.println("Child doctor" + this.getName() + "treated" + patient.getName() + "with 1 child-pill.");

        nurse.treat(patient);
    }

    public ChildDepartmentDoctor(String name, String login, String password) {
        super(name, login, password);
    }
}
