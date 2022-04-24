package by.ledza.hackbsuirserv.repository;

import by.ledza.hackbsuirserv.model.Beacon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface BeaconRepository extends MongoRepository<Beacon, UUID> {
    public List<Beacon> findAll();
    public void deleteAll();
}
