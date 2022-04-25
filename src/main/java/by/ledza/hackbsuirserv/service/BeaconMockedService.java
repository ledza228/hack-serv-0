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
    @Override
    public List<Beacon> getAllBeacons() {
        List<Beacon> beacons = new ArrayList<>();
        beacons.add(new Beacon("F1:FF:2A:77:00:7A", -69, new V3(12,33,0), 1));
        beacons.add(new Beacon("AA:91:B2:C1:B4:AA", -101, new V3(22,71,0), 2));
        beacons.add(new Beacon("88:FB:12:99:CC:9B", -69, new V3(81,61,0), 3));
        beacons.add(new Beacon("23:FF:2A:77:00:7A", -69, new V3(24,54,0), 1));
        beacons.add(new Beacon("53:FA:7A:7B:09:81", -69, new V3(15,77,0), 2));
        return beacons;
    }

    @Override
    public void putAllBeacons(List<Beacon> beacons) {

    }
}
