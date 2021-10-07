package innopolis.university.users.staff;

import innopolis.university.system.data.NurseController;
import innopolis.university.users.Patient;

public abstract class Nurse extends Staff {

    public abstract void treat(Patient patient);

    protected Nurse(String name, String login, String password) {
        super(name, login, password);
        this.id = NurseController.getInstance().getIdForNewEntity();
    }

    @Override
    public int getId() {
        return NurseController.getInstance().getIdForNewEntity();
    }
}
