package by.ledza.hackbsuirserv.repository;

import by.ledza.hackbsuirserv.model.Node;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NodeRepository extends MongoRepository<Node, Integer> {
    public List<Node> findAll();
    public void deleteAll();
}
