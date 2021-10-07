package innopolisuniversity.system.data;

import java.util.List;

public interface AbstractController<E, K> {
    List<E> getAll();

    E update(E entity);

    E getEntityById(K id);

    boolean delete(K id);

    boolean create(E entity);

    K getIdForNewEntity();
}
