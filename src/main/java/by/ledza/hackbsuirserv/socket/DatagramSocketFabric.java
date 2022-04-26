package by.ledza.hackbsuirserv.socket;

import java.net.DatagramSocket;
import java.net.SocketException;

public abstract class DatagramSocketFabric {

    public abstract DatagramSocket getNewSocket() throws SocketException;
}
