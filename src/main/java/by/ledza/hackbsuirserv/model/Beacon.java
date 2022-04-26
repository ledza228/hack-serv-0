package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "beacons")
public class Beacon {

    @Id
    private String mac;

    private Integer tx_power;
    private V3 coord;
    private Integer node;
}
