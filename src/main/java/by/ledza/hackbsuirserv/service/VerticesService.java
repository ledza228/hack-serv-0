package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.model.Vertice;
import by.ledza.hackbsuirserv.model.VerticeInfo;
import by.ledza.hackbsuirserv.model.VerticesTypes;
import by.ledza.hackbsuirserv.model.V3;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VerticesService {

    public List<Vertice> getAllVertices(){
        List<Vertice> vertices = new ArrayList<>();

        vertices.add(new Vertice(0, new V3(Arrays.asList(61,75,0)), VerticesTypes.Exit, List.of(1)));
        vertices.add(new Vertice(1, new V3(Arrays.asList(206,160,0)), VerticesTypes.Pavilion, List.of(0, 2)));
        vertices.add(new Vertice(2, new V3(Arrays.asList(302,251,0)), VerticesTypes.Junktion, List.of(1, 3, 5)));
        vertices.add(new Vertice(3, new V3(Arrays.asList(311,382,0)), VerticesTypes.Pavilion, List.of(2, 4)));
        vertices.add(new Vertice(4, new V3(Arrays.asList(480,383,0)), VerticesTypes.Pavilion, List.of(3, 5)));
        vertices.add(new Vertice(5, new V3(Arrays.asList(549,253,0)), VerticesTypes.Pavilion, List.of(4, 2)));

        return vertices;
    }

    public List<VerticeInfo> getVerticesNames(){
        List<VerticeInfo> verticeNames = new ArrayList<>();

        verticeNames.add(new VerticeInfo(0, "столовая БГУИР"));
        verticeNames.add(new VerticeInfo(1, "McDonalds"));
        verticeNames.add(new VerticeInfo(2, "Zara"));
        verticeNames.add(new VerticeInfo(3, "StarBucks"));
        verticeNames.add(new VerticeInfo(4, "У дяди Васи"));
        verticeNames.add(new VerticeInfo(5, "столовая БНТУ"));

        return verticeNames;
    }

}
