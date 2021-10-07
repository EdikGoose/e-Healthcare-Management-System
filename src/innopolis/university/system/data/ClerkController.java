package innopolis.university.system.data;

import innopolis.university.system.Registry;
import innopolis.university.users.staff.Clerk;

import java.util.List;

public final class ClerkController implements AbstractController<Clerk, Integer> {

    private static ClerkController instance;

    private ClerkController() { }

    @Override
    public List<Clerk> getAll() {
        return Database.getInstance().getClerks().values().stream().toList();
    }

    @Override
    public Clerk update(Clerk entity) {
        return Database.getInstance().getClerks().replace(entity.getId(), entity);
    }

    @Override
    public Clerk getEntityById(Integer id) {
        return Database.getInstance().getClerks().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getClerks().remove(id) != null);
    }

    @Override
    public boolean create(Clerk entity){
        return (Database.getInstance().getClerks().put(entity.getId(), entity) != null );
    }

    public static ClerkController getInstance() {
        if (instance == null) {
            synchronized (Registry.class) {
                if (instance == null) {
                    instance = new ClerkController();
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
