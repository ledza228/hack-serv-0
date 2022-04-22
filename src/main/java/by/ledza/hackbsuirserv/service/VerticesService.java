package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.model.Vertice;
import by.ledza.hackbsuirserv.model.VerticeName;
import by.ledza.hackbsuirserv.model.VerticesTypes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VerticesService {

    public List<Vertice> getAllVertices(){
        List<Vertice> vertices = new ArrayList<>();

        vertices.add(new Vertice(0L, Arrays.asList(61,75,0), VerticesTypes.Exit, List.of(1L)));
        vertices.add(new Vertice(1L, Arrays.asList(206,160,0), VerticesTypes.Pavilion, List.of(0L, 2L)));
        vertices.add(new Vertice(2L, Arrays.asList(302,251,0), VerticesTypes.Junktion, List.of(1L, 3L, 5L)));
        vertices.add(new Vertice(3L, Arrays.asList(311,382,0), VerticesTypes.Pavilion, List.of(2L, 4L)));
        vertices.add(new Vertice(4L, Arrays.asList(480,383,0), VerticesTypes.Pavilion, List.of(3L, 5L)));
        vertices.add(new Vertice(5L, Arrays.asList(549,253,0), VerticesTypes.Pavilion, List.of(4L, 2L)));

        return vertices;
    }

    public List<VerticeName> getVerticesNames(){
        List<VerticeName> verticeNames = new ArrayList<>();

        verticeNames.add(new VerticeName(0L, "столовая БГУИР"));
        verticeNames.add(new VerticeName(1L, "McDonalds"));
        verticeNames.add(new VerticeName(2L, "Zara"));
        verticeNames.add(new VerticeName(3L, "StarBucks"));
        verticeNames.add(new VerticeName(4L, "У дяди Васи"));
        verticeNames.add(new VerticeName(5L, "столовая БНТУ"));

        return verticeNames;
    }

}
