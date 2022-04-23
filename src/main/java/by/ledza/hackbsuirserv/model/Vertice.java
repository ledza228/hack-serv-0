package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vertice {

    private Integer id;

    private V3 coords;

    private VerticesTypes type;

    private List<Integer> arrIDs;

}
