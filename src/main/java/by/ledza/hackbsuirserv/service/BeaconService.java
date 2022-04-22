package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.model.Beacon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class BeaconService {

    public List<Beacon> getAllBeacons(){
        List<Beacon> beacons = new ArrayList<>();
        beacons.add(new Beacon(UUID.randomUUID(), Arrays.asList(66,73,0),0));
        beacons.add(new Beacon(UUID.randomUUID(), Arrays.asList(211,158,0),1));
        beacons.add(new Beacon(UUID.randomUUID(), Arrays.asList(307,249,0),2));
        beacons.add(new Beacon(UUID.randomUUID(), Arrays.asList(316,380,0),3));
        beacons.add(new Beacon(UUID.randomUUID(), Arrays.asList(485,381,0),4));
        beacons.add(new Beacon(UUID.randomUUID(), Arrays.asList(554,251,0),5));

        return beacons;
    }

}
