package by.ledza.hackbsuirserv.controller;

import by.ledza.hackbsuirserv.dto.BeaconNodeDTO;
import by.ledza.hackbsuirserv.model.Beacon;
import by.ledza.hackbsuirserv.service.IBeaconService;
import by.ledza.hackbsuirserv.service.INodeService;
import by.ledza.hackbsuirserv.service.NodeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/beacons")
public class BeaconsController {

    @Autowired
    @Qualifier("mock")
    IBeaconService beaconService;

    @Autowired
    @Qualifier("mock")
    INodeService nodeService;

    @GetMapping("")
    public List<Beacon> allBeaconsAPI(){
        return beaconService.getAllBeacons();
    }

    @PostMapping(value = "")
    public void postNodesNodeInfoBeaconAPI(@RequestBody BeaconNodeDTO beaconNodeDTO){
        beaconService.putAllBeacons(beaconNodeDTO.getBeacons());
        nodeService.putNodes(beaconNodeDTO.getNodes());
        nodeService.putNodesName(beaconNodeDTO.getNodeInfos());
    }
}
