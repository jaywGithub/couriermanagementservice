package za.ac.cput.jayson.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.jayson.domain.customer.Customer;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
