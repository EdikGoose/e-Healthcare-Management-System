package innopolisuniversity.users.staff;

import innopolisuniversity.system.data.MedicineController;
import innopolisuniversity.users.Patient;

public class AdultDepartmentNurse extends Nurse {

    public void treat(Patient patient) {
        MedicineController.getInstance().reduceMedicines();
        System.out.println("Adult nurse" + this.getName() + "treated" + patient.getName() + "with 1 adult-injection.");
    }

    public AdultDepartmentNurse(String name, String login, String password) {
        super(name, login, password);
    }


}
