package za.ac.cput.jayson.repositories;

import org.springframework.stereotype.Repository;
import za.ac.cput.jayson.domain.branch.Branch;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
}
