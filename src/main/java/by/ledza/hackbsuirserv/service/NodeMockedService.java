package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;
import by.ledza.hackbsuirserv.model.V3;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("mock")
public class NodeMockedService implements INodeService{
    @Override
    public List<Node> getAllNodes() {
        return null;
    }

    @Override
    public List<NodeInfo> getNodesName() {
        return null;
    }

    @Override
    public List<NodeDTO> getNodesDTO() {
        List<NodeDTO> nodes = new ArrayList<>();
        nodes.add(new NodeDTO(0,new V3(10,22,0),1,List.of(1,2,3),"Лавка"));
        nodes.add(new NodeDTO(1,new V3(44,12,0),0,List.of(0,2),""));
        nodes.add(new NodeDTO(2,new V3(55,99,0),2,List.of(0),"У дяди Богдана"));
        nodes.add(new NodeDTO(3,new V3(55,11,0),1,List.of(1,2),"McDonald's"));

        return nodes;
    }

    @Override
    public void putNodesName(List<NodeInfo> nodeInfos) {

    }

    @Override
    public void putNodes(List<Node> nodes) {

    }
}
