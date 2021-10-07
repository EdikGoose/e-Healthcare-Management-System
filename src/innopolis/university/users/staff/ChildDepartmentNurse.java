package innopolis.university.users.staff;

import innopolis.university.system.data.MedicineController;
import innopolis.university.users.Patient;

public class ChildDepartmentNurse extends Nurse {


    public void treat(Patient patient) {
        MedicineController.getInstance().reduceMedicines();
        System.out.println("Child nurse" + this.getName() + "treated" + patient.getName() + "with 1 child-injection.");
    }

    public ChildDepartmentNurse(String name, String login, String password) {
        super(name, login, password);
    }


}
