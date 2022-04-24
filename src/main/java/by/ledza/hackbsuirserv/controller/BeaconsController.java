package by.ledza.hackbsuirserv.controller;

import by.ledza.hackbsuirserv.dto.BeaconNodeDTO;
import by.ledza.hackbsuirserv.model.Beacon;
import by.ledza.hackbsuirserv.service.BeaconService;
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
    BeaconService beaconService;

    @GetMapping("")
    public List<Beacon> allBeaconsAPI(){
        return beaconService.getAllBeacons();
    }

    @PostMapping(value = "", consumes = "application/json")
    public BeaconNodeDTO postBeaconsAPI(@RequestBody BeaconNodeDTO beaconNodeDTO){
        beaconService.putAllBeacons(beaconNodeDTO.getBeacons());
        return beaconNodeDTO;
    }
}
