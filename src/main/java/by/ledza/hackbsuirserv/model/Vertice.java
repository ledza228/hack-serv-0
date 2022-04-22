package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vertice {

    private Long id;

    private List<Integer> coords;

    private VerticesTypes type;

    private List<Long> arrIDs;

}
