package by.ledza.hackbsuirserv.model;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "nodes")
public class Node {

    @Id
    private Integer id;

    private V3 coords;
    private Integer type;
    private List<Integer> arrIDs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public V3 getCoords() {
        return coords;
    }

    public void setCoords(V3 coords) {
        this.coords = coords;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Integer> getArrIDs() {
        return arrIDs;
    }

    public void setArrIDs(List<Integer> arrIDs) {
        this.arrIDs = arrIDs;
    }
}
