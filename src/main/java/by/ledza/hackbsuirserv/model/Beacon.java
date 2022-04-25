package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Document(collection = "beacons")
public class Beacon {

    @Id
    private UUID uuid;

    private V3 coord;
    private Integer node;
}
