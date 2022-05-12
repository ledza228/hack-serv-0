package by.ledza.hackbsuirserv.socket;

import by.ledza.hackbsuirserv.socket.dto.AndroidBeaconDTO;
import by.ledza.hackbsuirserv.model.V3;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    private DatagramSocketFabric datagramSocketFabric;

    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Value("${udp.server.hostname}")
    private String udpHostName;

    @Value("${udp.server.port}")
    private String udpHostPort;

    private final HashMap<WebSocketSession, DatagramSocket> sessionMap = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        DatagramSocket socket = datagramSocketFabric.getNewSocket();
        sessionMap.put(session, socket);

        UdpReceiverRunnable receiverThread = new UdpReceiverRunnable(session, socket);
        Thread thread = new Thread(receiverThread);
        thread.start();

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

        System.out.println(message.getPayload());

        try {
            DatagramSocket socket = sessionMap.get(session);
            UdpBeaconConverter udpBeaconConverter = new UdpBeaconConverter();
            List<AndroidBeaconDTO> androidBeacons = jsonMapper.readValue(message.getPayload(), new TypeReference<List<AndroidBeaconDTO>>() {});
            for (AndroidBeaconDTO androidBeacon : androidBeacons) {
                byte[] data = udpBeaconConverter.convertToUDPBeacon(androidBeacon);
                socket.send(new DatagramPacket(data, data.length, InetAddress.getByName(udpHostName),Integer.parseInt(udpHostPort)));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("beacon parsing error");
            return;
        }
    }


}
