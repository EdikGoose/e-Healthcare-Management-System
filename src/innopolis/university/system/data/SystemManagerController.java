package innopolis.university.system.data;

import innopolis.university.users.SystemManager;

import java.util.List;

public final class SystemManagerController implements AbstractController<SystemManager, Integer> {

    private static SystemManagerController instance;

    private SystemManagerController() { }

    @Override
    public List<SystemManager> getAll(){
        return Database.getInstance().getSystemManagers().values().stream().toList();
    }

    @Override
    public SystemManager update(SystemManager entity) {
        return Database.getInstance().getSystemManagers().replace(entity.getId(), entity);
    }

    @Override
    public SystemManager getEntityById(Integer id) {
        return Database.getInstance().getSystemManagers().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getSystemManagers().remove(id) != null);
    }

    @Override
    public boolean create(SystemManager entity){
        return (Database.getInstance().getSystemManagers().put(entity.getId(), entity) != null );
    }

    public static SystemManagerController getInstance() {
        if (instance == null) {
            synchronized (SystemManagerController.class) {
                if (instance == null) {
                    instance = new SystemManagerController();
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
