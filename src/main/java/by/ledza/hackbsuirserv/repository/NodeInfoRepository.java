package by.ledza.hackbsuirserv.repository;

import by.ledza.hackbsuirserv.model.NodeInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NodeInfoRepository extends MongoRepository<NodeInfo, Integer> {
    public List<NodeInfo> findAll();
    public void deleteAll();
}
