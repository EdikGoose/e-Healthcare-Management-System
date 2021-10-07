package innopolisuniversity.users.staff;

public class AdultDepartmentStaffFactory implements StaffFactory {

    @Override
    public Doctor createDoctor(String name, String login, String password) {
        return new AdultDepartmentDoctor(name, login, password);
    }

    @Override
    public Nurse createNurse(String name, String login, String password) {
        return new AdultDepartmentNurse(name, login, password);
    }
}
