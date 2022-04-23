package by.ledza.hackbsuirserv.socket;

import by.ledza.hackbsuirserv.model.V3;
import org.json.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.Random;

public class WebSocketHandler extends AbstractWebSocketHandler {

    Random random = new Random();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        V3 position = new V3(random.nextInt(1000), random.nextInt(1000), 0);
        JSONObject json = new JSONObject(position);
        System.out.println(message);
        session.sendMessage(new TextMessage(json.toString()));
    }
}
