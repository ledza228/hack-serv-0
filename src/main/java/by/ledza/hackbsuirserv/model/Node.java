package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Node {

    private Integer id;

    private V3 coords;

    private NodeTypes type;

    private List<Integer> arrIDs;

}
