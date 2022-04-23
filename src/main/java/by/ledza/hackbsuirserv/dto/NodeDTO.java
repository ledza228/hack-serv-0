package by.ledza.hackbsuirserv.dto;

import by.ledza.hackbsuirserv.model.NodeTypes;
import by.ledza.hackbsuirserv.model.V3;
import lombok.Data;

import java.util.List;

@Data
public class NodeDTO {

    private Integer id;

    private V3 coords;

    private NodeTypes type;

    private List<Integer> arrIDs;

    private String name;
}
