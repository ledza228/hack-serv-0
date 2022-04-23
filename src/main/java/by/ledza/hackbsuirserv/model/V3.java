package by.ledza.hackbsuirserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class V3 {

    private Integer x;
    private Integer y;
    private Integer z;

    public V3(List<Integer> list){
        x = list.get(0);
        y = list.get(1);
        z = list.get(2);
    }

}
