package innopolis.university.users.staff;

public class ChildDepartmentStaffFactory implements StaffFactory {

    @Override
    public Doctor createDoctor(String name, String login, String password) {
        return new ChildDepartmentDoctor(name, login, password);
    }

    @Override
    public Nurse createNurse(String name, String login, String password) {
        return new ChildDepartmentNurse(name, login, password);
    }
}
