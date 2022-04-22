package by.ledza.hackbsuirserv.controller;

import by.ledza.hackbsuirserv.model.Vertice;
import by.ledza.hackbsuirserv.model.VerticeName;
import by.ledza.hackbsuirserv.service.VerticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vertices/")
public class VerticesController {

    @Autowired
    VerticesService verticesService;

    @GetMapping("/")
    public List<Vertice> getAllVerticesAPI(){
        return verticesService.getAllVertices();
    }

    @GetMapping("/names")
    public List<VerticeName> getAllVerticesNamesAPI(){
        return verticesService.getVerticesNames();
    }

}
