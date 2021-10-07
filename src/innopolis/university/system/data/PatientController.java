package innopolis.university.system.data;

import innopolis.university.users.Patient;

import java.util.List;

public final class PatientController implements AbstractController<Patient, Integer> {

    private static PatientController instance;

    private PatientController() { }

    @Override
    public List<Patient> getAll(){
        return Database.getInstance().getPatients().values().stream().toList();
    }

    @Override
    public Patient update(Patient entity) {
        return Database.getInstance().getPatients().replace(entity.getId(), entity);
    }

    @Override
    public Patient getEntityById(Integer id) {
        return Database.getInstance().getPatients().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getPatients().remove(id) != null);
    }

    @Override
    public boolean create(Patient entity){
        return (Database.getInstance().getPatients().put(entity.getId(), entity) != null );
    }

    public static PatientController getInstance() {
        if (instance == null) {
            synchronized (PatientController.class) {
                if (instance == null) {
                    instance = new PatientController();
                }
            }
        }
        return instance;
    }

    @Override
    public Integer getIdForNewEntity() {
        return getAll().size();
    }
}
