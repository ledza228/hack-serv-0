package by.ledza.hackbsuirserv.repository;

import by.ledza.hackbsuirserv.model.Beacon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BeaconRepository extends MongoRepository<Beacon, String> {
    public List<Beacon> findAll();
    public void deleteAll();
}
