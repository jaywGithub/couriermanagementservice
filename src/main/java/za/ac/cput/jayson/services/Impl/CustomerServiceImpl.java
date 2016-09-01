package za.ac.cput.jayson.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.jayson.domain.customer.Customer;
import za.ac.cput.jayson.repositories.CustomerRepository;
import za.ac.cput.jayson.services.CustomerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer findById(Long aLong) {
        return null;
    }

    @Override
    public Customer save(Customer entity) {
        return null;
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allCust = new ArrayList<>();
        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            allCust.add(customer);
        }
        return allCust;
    }

    /*@Override
    public Customer create(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Customer> readAll() {
        Set<Customer> result = new HashSet<Customer>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Customer entity) {
        repository.delete(entity);

    }*/

}
