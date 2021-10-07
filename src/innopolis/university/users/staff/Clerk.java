package innopolis.university.users.staff;

import innopolis.university.system.data.ClerkController;

public class Clerk extends Staff {

    public Clerk(String name, String login, String password) {
        super(name, login, password);
        this.id = ClerkController.getInstance().getIdForNewEntity();
    }

    @Override
    public int getId() {
        return ClerkController.getInstance().getIdForNewEntity();
    }
}
