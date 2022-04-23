package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.mapper.NodeMapper;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;
import by.ledza.hackbsuirserv.model.NodeTypes;
import by.ledza.hackbsuirserv.model.V3;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NodeService {

    NodeMapper nodeMapper = Mappers.getMapper(NodeMapper.class);
    public List<Node> getAllNodes(){
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node(0, new V3(Arrays.asList(61,75,0)), NodeTypes.Exit, List.of(1)));
        nodes.add(new Node(1, new V3(Arrays.asList(206,160,0)), NodeTypes.Pavilion, List.of(0, 2)));
        nodes.add(new Node(2, new V3(Arrays.asList(302,251,0)), NodeTypes.Junktion, List.of(1, 3, 5)));
        nodes.add(new Node(3, new V3(Arrays.asList(311,382,0)), NodeTypes.Pavilion, List.of(2, 4)));
        nodes.add(new Node(4, new V3(Arrays.asList(480,383,0)), NodeTypes.Pavilion, List.of(3, 5)));
        nodes.add(new Node(5, new V3(Arrays.asList(549,253,0)), NodeTypes.Pavilion, List.of(4, 2)));

        return nodes;
    }

    public List<NodeInfo> getNodesName(){
        List<NodeInfo> NodeNames = new ArrayList<>();

        NodeNames.add(new NodeInfo(0, "столовая БГУИР"));
        NodeNames.add(new NodeInfo(1, "McDonalds"));
        NodeNames.add(new NodeInfo(2, "Zara"));
        NodeNames.add(new NodeInfo(3, "StarBucks"));
        NodeNames.add(new NodeInfo(4, "У дяди Васи"));
        NodeNames.add(new NodeInfo(5, "столовая БНТУ"));

        return NodeNames;
    }

    public List<NodeDTO> getNodesDTO(){
        List<NodeDTO> nodes =  nodeMapper.nodesToNodeDTOs(getAllNodes());
        nodes.forEach(i -> i.setName(getNodesName().get(i.getId()).getName()));
        return nodes;
    }

}
