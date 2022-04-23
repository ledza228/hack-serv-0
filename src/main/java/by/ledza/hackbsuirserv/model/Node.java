package by.ledza.hackbsuirserv.model;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Node {

    private Integer id;

    private V3 coords;

    private Integer type;

    private List<Integer> arrIDs;

}
