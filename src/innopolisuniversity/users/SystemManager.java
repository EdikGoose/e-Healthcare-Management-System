package innopolisuniversity.users;

import innopolisuniversity.system.SpecializationEnum;
import innopolis.university.system.data.*;
import innopolis.university.users.staff.*;
import innopolisuniversity.system.data.*;
import innopolisuniversity.users.staff.AdultDepartmentStaffFactory;
import innopolisuniversity.users.staff.ChildDepartmentStaffFactory;
import innopolisuniversity.users.staff.Clerk;
import innopolisuniversity.users.staff.StaffFactory;


public class SystemManager extends User {

    public SystemManager(String name, String login, String password) {
        super(name, login, password);
        this.id = SystemManagerController.getInstance().getIdForNewEntity();
    }


    public void hireDoctor(String login, String password, String name, SpecializationEnum specialization) {
        StaffFactory factory = getFactoryBySpecialization(specialization);
        DoctorController.getInstance().create(factory.createDoctor(name, login, password));
    }

    public void fireDoctor(int doctorId){
        DoctorController.getInstance().delete(doctorId);
    }


    public void fireNurse(int nurseId){
        DoctorController.getInstance().delete(nurseId);
    }

    public void hireNurse(String login, String password, String name, SpecializationEnum specialization) {
        StaffFactory factory = getFactoryBySpecialization(specialization);
        NurseController.getInstance().create(factory.createNurse(name, login, password));
    }


    public void fireClerk(int ClerkId){
        ClerkController.getInstance().delete(ClerkId);
    }

    public void hireClerk(String login, String password, String name){
        ClerkController.getInstance().create(new Clerk(name,login,password));
    }


    public void addMedicine(){
        MedicineController.getInstance().addMedicine();
    }


    @Override
    public int getId() {
        return SystemManagerController.getInstance().getIdForNewEntity();
    }


    private StaffFactory getFactoryBySpecialization(SpecializationEnum specialization) {
        StaffFactory factory;
        switch (specialization) {
            case ADULT -> factory = new AdultDepartmentStaffFactory();
            case CHILD -> factory = new ChildDepartmentStaffFactory();
            default -> throw new IllegalArgumentException("Unexpected value of specialization: " + specialization);
        }
        return factory;
    }
}
