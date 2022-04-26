package by.ledza.hackbsuirserv.socket;

import by.ledza.hackbsuirserv.socket.dto.AndroidBeaconDTO;
import by.ledza.hackbsuirserv.model.V3;
import by.ledza.hackbsuirserv.socket.dto.UdpBeaconDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Random;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    private DatagramSocketFabric datagramSocketFabric;

    private Random random = new Random();

    private ObjectMapper jsonMapper = new ObjectMapper();

    private Integer x = 100;
    private Integer y = 100;

    private HashMap<WebSocketSession, DatagramSocket> sessionMap = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.put(session, datagramSocketFabric.getNewSocket());
        System.out.println(sessionMap.keySet());
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.get(session).close();
        sessionMap.remove(session);
        System.out.println(sessionMap.keySet());
        super.afterConnectionClosed(session, status);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        AndroidBeaconDTO androidBeaconDTO = new AndroidBeaconDTO();
        androidBeaconDTO.setMyId("00:23:32:11:FE:12");
        androidBeaconDTO.setFoundId("12:32:31:AA:FB:FE");
        androidBeaconDTO.setRssi(1);
        androidBeaconDTO.setTxPower(100);
        androidBeaconDTO.setWhoAmI(1);

        AndroidBeaconDTO beacon = androidBeaconDTO;
        try {
            UdpBeaconDTO udpBeaconDTO = new UdpBeaconDTO();
            byte[] data = udpBeaconDTO.convertToUDPBeacon(beacon);
            DatagramSocket socket = sessionMap.get(session);
            //socket.send(new DatagramPacket(data, data.length, InetAddress.getByName("192.168.158.65"),7010));
            //beacon = jsonMapper.convertValue(message.getPayload(), AndroidBeaconDTO.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("beacon parsing error");
            return;
        }

        V3 position = new V3(x, y, 0);
        x += random.nextInt(10) - 5;
        y += random.nextInt(10) - 5;
        JSONObject json = new JSONObject(position);
        System.out.println(message.getPayload());
        session.sendMessage(new TextMessage(json.toString()));
    }


}
