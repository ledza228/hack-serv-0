package by.ledza.hackbsuirserv.dto;

import by.ledza.hackbsuirserv.model.NodeTypes;
import by.ledza.hackbsuirserv.model.V3;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NodeDTO {

    private Integer id;

    private V3 coord;

    private Integer type;

    private List<Integer> arrIDs;

    private String name;
}
