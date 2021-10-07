package innopolis.university.users.staff;

public interface StaffFactory {
    Doctor createDoctor(String name, String login, String password);
    Nurse createNurse(String name, String login, String password);
}
