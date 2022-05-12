package by.ledza.hackbsuirserv.socket;

import by.ledza.hackbsuirserv.model.V3;
import org.json.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiverRunnable implements Runnable{

    private final WebSocketSession session;
    private final DatagramSocket socket;

    public UdpReceiverRunnable(WebSocketSession session, DatagramSocket socket){
        this.session = session;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            udpSocketReceive(session, socket);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Error while sending");
        }
    }

    private void udpSocketReceive(WebSocketSession session, DatagramSocket socket) throws IOException {
        while (!socket.isClosed()){
            byte[] buffer = new byte[300];
            DatagramPacket packet = new DatagramPacket(buffer, 300);
            socket.receive(packet);

            System.out.println("Get something");

            UdpBeaconConverter udpBeaconConverter = new UdpBeaconConverter();
            V3 pos = udpBeaconConverter.convertPacketToJson(packet.getData());
            System.out.println("Converted");
            System.out.println(pos);

            if (pos == null)
                continue;

            JSONObject json = new JSONObject(pos);
            session.sendMessage(new TextMessage(json.toString()));
        }
    }
}
