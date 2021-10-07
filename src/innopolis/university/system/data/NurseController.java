package innopolis.university.system.data;

import innopolis.university.users.staff.Nurse;

import java.util.List;

public final class NurseController implements AbstractController<Nurse, Integer> {

    private static NurseController instance;

    private NurseController() { }

    @Override
    public List<Nurse> getAll(){
        return Database.getInstance().getNurses().values().stream().toList();
    }

    @Override
    public Nurse update(Nurse entity) {
        return Database.getInstance().getNurses().replace(entity.getId(), entity);
    }

    @Override
    public Nurse getEntityById(Integer id) {
        return Database.getInstance().getNurses().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getNurses().remove(id) != null);
    }

    @Override
    public boolean create(Nurse entity){
        return (Database.getInstance().getNurses().put(entity.getId(), entity) != null );
    }

    public static NurseController getInstance() {
        if (instance == null) {
            synchronized (PatientController.class) {
                if (instance == null) {
                    instance = new NurseController();
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
