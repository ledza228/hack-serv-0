package by.ledza.hackbsuirserv.dto;

import by.ledza.hackbsuirserv.model.Beacon;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class BeaconNodeDTO {
    private List<Node> nodes;
    private List<NodeInfo> nodeInfos;
    private List<Beacon> beacons;
}
