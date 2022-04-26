package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;

import java.util.List;

public interface INodeService {

    public List<Node> getAllNodes();

    public List<NodeInfo> getNodesName();

    public List<NodeDTO> getNodesDTO();

    public void putNodesName(List<NodeInfo> nodeInfos);

    public void putNodes(List<Node> nodes);
}
