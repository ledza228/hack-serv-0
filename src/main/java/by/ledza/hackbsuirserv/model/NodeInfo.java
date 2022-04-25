package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = "nodesInfos")
public class NodeInfo {

    @Id
    private Integer id;
    private String name;
}
