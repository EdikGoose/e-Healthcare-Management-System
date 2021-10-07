package innopolis.university.system.data;

import innopolis.university.system.Report;

import java.util.List;

public final class ReportController implements AbstractController<Report, Integer> {

    private static ReportController instance;

    private ReportController() { }

    @Override
    public List<Report> getAll(){
        return Database.getInstance().getReports().values().stream().toList();
    }

    @Override
    public Report update(Report entity) {
        return Database.getInstance().getReports().replace(entity.id(), entity);
    }

    @Override
    public Report getEntityById(Integer id) {
        return Database.getInstance().getReports().get(id);
    }

    @Override
    public boolean delete(Integer id) {
        return (Database.getInstance().getReports().remove(id) != null);
    }

    @Override
    public boolean create(Report entity) {
        return (Database.getInstance().getReports().put(entity.id(), entity) != null );
    }

    public static ReportController getInstance() {
        if (instance == null) {
            synchronized (ReportController.class) {
                if (instance == null) {
                    instance = new ReportController();
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
