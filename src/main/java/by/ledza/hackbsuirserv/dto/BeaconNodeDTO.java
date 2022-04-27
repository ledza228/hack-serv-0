package by.ledza.hackbsuirserv.dto;

import by.ledza.hackbsuirserv.model.Beacon;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BeaconNodeDTO {

    @JsonProperty("nodes")
    private List<Node> nodes;

    @JsonProperty("nodeInfos")
    private List<NodeInfo> nodeInfos;

    @JsonProperty("beacons")
    private List<Beacon> beacons;
}
