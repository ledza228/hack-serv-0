package by.ledza.hackbsuirserv.model;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "nodes")
public class Node {

    @Id
    private Integer id;

    private V3 coord;
    private Integer type;
    private List<Integer> arrIDs;
}
