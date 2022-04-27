package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.mapper.NodeMapper;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;
import by.ledza.hackbsuirserv.model.V3;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("mock")
public class NodeMockedService implements INodeService{

    List<Node> nodes = new ArrayList<>();

    List<NodeInfo> names = new ArrayList<>();

    NodeMapper nodeMapper = Mappers.getMapper(NodeMapper.class);

    @Override
    public List<Node> getAllNodes() {
        return nodes;
    }

    @Override
    public List<NodeInfo> getNodesName() {
        return names;
    }

    @Override
    public List<NodeDTO> getNodesDTO() {
        List<NodeDTO> nodes =  nodeMapper.nodesToNodeDTOs(getAllNodes());
        List<NodeInfo> infos = getNodesName();
        for (NodeInfo info : infos){
            nodes.forEach(node -> {
                if (node.getId().equals(info.getId()))
                    node.setName(info.getName());
            });
        }
        return nodes;
    }

    @Override
    public void putNodesName(List<NodeInfo> nodeInfos) {
        names = nodeInfos;
    }

    @Override
    public void putNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
