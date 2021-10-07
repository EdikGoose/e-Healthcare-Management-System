package innopolisuniversity.system.data;

import innopolisuniversity.system.Ward;

import java.util.List;

public class WardController implements AbstractController<Ward, Integer> {

    private static WardController instance;

    private WardController() { }

    @Override
    public List<Ward> getAll() {
        return Database.getInstance().getWards().values().stream().toList();
    }

    @Override
    public Ward update(Ward entity) {
        return Database.getInstance().getWards().replace(entity.getId(), entity);
    }

    @Override
    public Ward getEntityById(Integer id) {
        return Database.getInstance().getWards().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getWards().remove(id) != null);
    }

    @Override
    public boolean create(Ward entity) {
        return (Database.getInstance().getWards().put(entity.getId(), entity) != null );
    }

    public static WardController getInstance() {
        if (instance == null) {
            synchronized (WardController.class) {
                if (instance == null) {
                    instance = new WardController();
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
