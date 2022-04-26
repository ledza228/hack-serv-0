package by.ledza.hackbsuirserv.controller;

import by.ledza.hackbsuirserv.dto.BeaconNodeDTO;
import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.service.INodeService;
import by.ledza.hackbsuirserv.service.NodeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nodes")
public class NodeController {

    @Autowired
    @Qualifier("mockedNode")
    INodeService nodeService;

    @GetMapping("")
    public List<NodeDTO> getAllVerticesAPI(){
        return nodeService.getNodesDTO();
    }

    @PostMapping(value = "", consumes = "application/json")
    public BeaconNodeDTO postAllVerticesAPI(@RequestBody BeaconNodeDTO beaconNodeDTO){
        nodeService.putNodes(beaconNodeDTO.getNodes());
        nodeService.putNodesName(beaconNodeDTO.getNodeInfos());
        return beaconNodeDTO;
    }
}
