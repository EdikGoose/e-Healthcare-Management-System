package innopolis.university.system.data;

import innopolis.university.users.staff.AdultDepartmentDoctor;
import innopolis.university.users.staff.ChildDepartmentDoctor;
import innopolis.university.users.staff.Doctor;

import java.util.List;

public final class DoctorController implements AbstractController<Doctor, Integer> {

    private static DoctorController instance;

    private DoctorController() { }

    @Override
    public List<Doctor> getAll() {
        return Database.getInstance().getDoctors().values().stream().toList();
    }

    @Override
    public Doctor update(Doctor entity) {
        return Database.getInstance().getDoctors().replace(entity.getId(), entity);
    }

    @Override
    public Doctor getEntityById(Integer id) {
        return Database.getInstance().getDoctors().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getDoctors().remove(id) != null);
    }

    @Override
    public boolean create(Doctor entity) {
        return (Database.getInstance().getDoctors().put(entity.getId(), entity) != null );
    }

    public static DoctorController getInstance() {
        if (instance == null) {
            synchronized (DoctorController.class) {
                if (instance == null) {
                    instance = new DoctorController();
                }
            }
        }
        return instance;
    }

    @Override
    public Integer getIdForNewEntity() {
        return getAll().size();
    }

    public List<AdultDepartmentDoctor> getAdultDepartmentDoctors() {
        return getAll().stream().filter(doctor -> doctor instanceof AdultDepartmentDoctor)
                .map(doctor -> (AdultDepartmentDoctor) doctor).toList();
    }

    public List<ChildDepartmentDoctor> getChildDepartmentDoctor() {
        return getAll().stream().filter(doctor -> doctor instanceof ChildDepartmentDoctor)
                .map(doctor -> (ChildDepartmentDoctor) doctor).toList();
    }
}
