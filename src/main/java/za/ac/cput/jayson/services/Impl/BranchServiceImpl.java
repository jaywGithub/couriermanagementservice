package za.ac.cput.jayson.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.jayson.domain.branch.Branch;
import za.ac.cput.jayson.repositories.BranchRepository;
import za.ac.cput.jayson.services.BranchService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository repository;

    @Override
    public Branch findById(Long aLong) {
        return null;
    }

    @Override
    public Branch save(Branch entity) {
        return null;
    }

    @Override
    public Branch update(Branch entity) {
        return null;
    }

    @Override
    public void delete(Branch entity) {

    }

    @Override
    public List<Branch> findAll() {
        List<Branch> allBranch = new ArrayList<>();
        Iterable<Branch> branches = repository.findAll();
        for (Branch branch : branches) {
            allBranch.add(branch);
        }
        return allBranch;
    }

    /*@Override
    public Branch create(Branch entity) {
        return repository.save(entity);
    }

    @Override
    public Branch readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Branch> readAll() {
        Set<Branch> result = new HashSet<Branch>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Branch update(Branch entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Branch entity) {
        repository.delete(entity);

    }*/

}
