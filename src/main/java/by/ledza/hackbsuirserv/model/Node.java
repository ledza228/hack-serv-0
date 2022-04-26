package by.ledza.hackbsuirserv.model;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "nodes")
public class Node {

    @Id
    private Integer id;

    private V3 cord;
    private Integer type;
    private List<Integer> arrIDs;
}
