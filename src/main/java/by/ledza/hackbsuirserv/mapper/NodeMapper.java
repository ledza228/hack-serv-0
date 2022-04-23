package by.ledza.hackbsuirserv.mapper;

import by.ledza.hackbsuirserv.dto.NodeDTO;
import by.ledza.hackbsuirserv.model.Node;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface NodeMapper {

    NodeDTO nodeToNodeDTO(Node node);

    List<NodeDTO> nodesToNodeDTOs(List<Node> nodes);
}
