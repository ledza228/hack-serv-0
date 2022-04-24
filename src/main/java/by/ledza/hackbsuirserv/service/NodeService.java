package by.ledza.hackbsuirserv.service;

import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.mapper.NodeMapper;
import by.ledza.hackbsuirserv.model.Node;
import by.ledza.hackbsuirserv.model.NodeInfo;
import by.ledza.hackbsuirserv.model.NodeTypes;
import by.ledza.hackbsuirserv.model.V3;
import by.ledza.hackbsuirserv.repository.NodeInfoRepository;
import by.ledza.hackbsuirserv.repository.NodeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private NodeInfoRepository nodeInfoRepository;

    NodeMapper nodeMapper = Mappers.getMapper(NodeMapper.class);
    public List<Node> getAllNodes(){
        return nodeRepository.findAll();
    }

    public List<NodeInfo> getNodesName(){
        return nodeInfoRepository.findAll();
    }

    public List<NodeDTO> getNodesDTO(){
        List<NodeDTO> nodes =  nodeMapper.nodesToNodeDTOs(getAllNodes());
        nodes.forEach(i -> i.setName(getNodesName().get(i.getId()).getName()));
        return nodes;
    }

    public void putNodesName(List<NodeInfo> nodeInfos){
        nodeInfoRepository.deleteAll();
        nodeInfoRepository.saveAll(nodeInfos);
    }

    public void putNodes(List<Node> nodes){
        nodeRepository.deleteAll();
        nodeRepository.saveAll(nodes);
    }
}
