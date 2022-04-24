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

    private List<Integer> coord;
    private Integer node;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Integer> getCoord() {
        return coord;
    }

    public void setCoord(List<Integer> coord) {
        this.coord = coord;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }
}
