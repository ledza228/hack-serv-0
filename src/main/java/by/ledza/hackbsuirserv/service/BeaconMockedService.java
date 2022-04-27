package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.model.Beacon;
import by.ledza.hackbsuirserv.model.V3;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Qualifier("mock")
@Service
public class BeaconMockedService implements IBeaconService{

    List<Beacon> beacons = new ArrayList<>();

    @Override
    public List<Beacon> getAllBeacons() {
        return beacons;
    }

    @Override
    public void putAllBeacons(List<Beacon> beacons) {
        this.beacons = beacons;
    }
}
