package by.ledza.hackbsuirserv.dto;

import by.ledza.hackbsuirserv.model.NodeTypes;
import by.ledza.hackbsuirserv.model.V3;
import lombok.Data;

import java.util.List;

@Data
public class NodeDTO {

    private Integer id;

    private List<Integer> coord;

    private Integer type;

    private List<Integer> arrIDs;

    private String name;
}
