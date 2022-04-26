package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.model.Beacon;
import by.ledza.hackbsuirserv.repository.BeaconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("beaconProd")
public class BeaconService implements IBeaconService{

    @Autowired
    BeaconRepository beaconRepository;

    public List<Beacon> getAllBeacons(){
        return beaconRepository.findAll();
    }

    public void putAllBeacons(List<Beacon> beacons){
        beaconRepository.deleteAll();
        beaconRepository.saveAll(beacons);
    }
}
