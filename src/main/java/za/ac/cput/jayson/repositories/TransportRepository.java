package za.ac.cput.jayson.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.jayson.domain.transport.Transport;

/**
 * Created by JAYSON on 2016-08-20.
 */

@Repository
public interface TransportRepository extends CrudRepository<Transport, Long> {
}
