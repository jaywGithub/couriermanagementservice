package za.ac.cput.jayson.services;

import java.util.List;
import java.util.Set;

/**
 * Created by JAYSON on 2016-08-20.
 */
public interface Service<E, ID> {

    public E findById(ID id);

    public E save(E entity);

    public E update(E entity);

    public void delete(E entity);

    public List<E> findAll();

}
