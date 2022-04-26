package by.ledza.hackbsuirserv.socket.dto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class UdpBeaconDTO {

    static private Byte PACKET_SIZE = 56;
    static private Byte TYPE_OF_PACKET = 0;

    ByteArrayOutputStream data;

    public byte[] convertToUDPBeacon(AndroidBeaconDTO androidBeacon) throws IOException {
        data = new ByteArrayOutputStream();

        data.write(androidBeacon.getWhoAmI().byteValue());

        data.write(TYPE_OF_PACKET);
        data.write(PACKET_SIZE);

        insertMacString(androidBeacon.getMyId());
        insertMacString(androidBeacon.getFoundId());

        data.write(ByteBuffer.allocate(4).putInt(androidBeacon.getRssi()).array());
        data.write(ByteBuffer.allocate(4).putInt(androidBeacon.getTxPower()).array());

        data.write(0);
        data.write(ByteBuffer.allocate(20).putInt(0).array());
        data.write(ByteBuffer.allocate(252).putInt(androidBeacon.getRssi()).array());

        System.out.println(data.size());
        System.out.println(data.toByteArray());
        return data.toByteArray();

    }

    private void insertMacString(String mac){
        String[] macNums = mac.split(":");


        for (String num: macNums)
            data.write(Integer.parseInt(num.toLowerCase(),16));

        data.write(0);
        data.write(0);
    }

}
