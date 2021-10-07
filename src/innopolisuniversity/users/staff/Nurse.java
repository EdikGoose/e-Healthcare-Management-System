package innopolisuniversity.users.staff;

import innopolisuniversity.system.data.NurseController;
import innopolisuniversity.users.Patient;

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
