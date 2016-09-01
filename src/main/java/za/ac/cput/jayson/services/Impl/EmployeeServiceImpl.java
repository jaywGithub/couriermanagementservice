package za.ac.cput.jayson.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.jayson.domain.employee.Employee;
import za.ac.cput.jayson.repositories.EmployeeRepository;
import za.ac.cput.jayson.services.EmployeeService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee findById(Long aLong) {
        return null;
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> allEmp = new ArrayList<>();
        Iterable<Employee> employees = repository.findAll();
        for (Employee employee : employees) {
            allEmp.add(employee);
        }
        return allEmp;
    }

    /*@Override
    public Employee create(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Employee readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Employee> readAll() {
        Set<Employee> result = new HashSet<Employee>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Employee update(Employee entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Employee entity) {
        repository.delete(entity);

    }*/

}
