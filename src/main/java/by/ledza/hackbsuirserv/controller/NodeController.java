package by.ledza.hackbsuirserv.controller;

import by.ledza.hackbsuirserv.dto.BeaconNodeDTO;
import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.service.IBeaconService;
import by.ledza.hackbsuirserv.service.INodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nodes")
public class NodeController {

    @Autowired
    @Qualifier("prod")
    INodeService nodeService;

    @Autowired
    @Qualifier("prod")
    IBeaconService beaconService;

    @GetMapping("")
    public List<NodeDTO> getAllVerticesAPI(){
        return nodeService.getNodesDTO();
    }

    @PostMapping(value = "", consumes = "application/json")
    public void postNodesAndNodeInfoAPI(@RequestBody BeaconNodeDTO beaconNodeDTO){
        nodeService.putNodes(beaconNodeDTO.getNodes());
        nodeService.putNodesName(beaconNodeDTO.getNodeInfos());
    }

    @GetMapping("/getJson")
    public BeaconNodeDTO getJson(){
        BeaconNodeDTO beaconNodeDTO = new BeaconNodeDTO();
        beaconNodeDTO.setNodes(nodeService.getAllNodes());
        beaconNodeDTO.setNodeInfos(nodeService.getNodesName());
        beaconNodeDTO.setBeacons(beaconService.getAllBeacons());
        return beaconNodeDTO;
    }
}
