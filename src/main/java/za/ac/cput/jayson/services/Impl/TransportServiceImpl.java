package za.ac.cput.jayson.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.jayson.domain.transport.Transport;
import za.ac.cput.jayson.repositories.TransportRepository;
import za.ac.cput.jayson.services.TransportService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportRepository repository;

    @Override
    public Transport findById(Long aLong) {
        return null;
    }

    @Override
    public Transport save(Transport entity) {
        return null;
    }

    @Override
    public Transport update(Transport entity) {
        return null;
    }

    @Override
    public void delete(Transport entity) {

    }

    @Override
    public List<Transport> findAll() {
        List<Transport> allTrans = new ArrayList<>();
        Iterable<Transport> transports = repository.findAll();
        for (Transport transport : transports) {
            allTrans.add(transport);
        }
        return allTrans;
    }

    /*@Override
    public Transport create(Transport entity) {
        return repository.save(entity);
    }

    @Override
    public Transport readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Transport> readAll() {
        Set<Transport> result = new HashSet<Transport>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Transport update(Transport entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Transport entity) {
        repository.delete(entity);

    }*/

}
