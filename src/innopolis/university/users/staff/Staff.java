package innopolis.university.users.staff;

import innopolis.university.users.User;

public abstract class Staff extends User {

    protected Staff(String name, String login, String password) {
        super(name, login, password);
    }
}
