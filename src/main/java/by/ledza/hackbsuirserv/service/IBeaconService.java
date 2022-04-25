package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.model.Beacon;

import java.util.List;

public interface IBeaconService {

    public List<Beacon> getAllBeacons();

    public void putAllBeacons(List<Beacon> beacons);
}
