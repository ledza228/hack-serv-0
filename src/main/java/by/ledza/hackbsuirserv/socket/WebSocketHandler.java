package by.ledza.hackbsuirserv.socket;

import by.ledza.hackbsuirserv.model.V3;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Random;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    private DatagramSocketFabric datagramSocketFabric;

    private Random random = new Random();

    private HashMap<WebSocketSession, DatagramSocket> sessionMap = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.put(session, datagramSocketFabric.getNewSocket());
        System.out.println(sessionMap.keySet());
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session);
        System.out.println(sessionMap.keySet());
        super.afterConnectionClosed(session, status);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        V3 position = new V3(random.nextInt(1000), random.nextInt(1000), 0);
        JSONObject json = new JSONObject(position);
        System.out.println(message);
        session.sendMessage(new TextMessage(json.toString()));
    }


}
