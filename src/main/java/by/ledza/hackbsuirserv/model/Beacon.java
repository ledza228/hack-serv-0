package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Beacon {

    private UUID uuid;

    private List<Integer> coord;

    private Integer node;

}
