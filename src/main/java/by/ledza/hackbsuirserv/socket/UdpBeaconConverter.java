package by.ledza.hackbsuirserv.socket;

import by.ledza.hackbsuirserv.model.V3;
import by.ledza.hackbsuirserv.socket.dto.AndroidBeaconDTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;


public class UdpBeaconConverter {

    static private final Byte PACKET_SIZE = 56;
    static private final Byte TYPE_OF_PACKET = 0;
    static private final Byte IS_THERE_CORD_OFFSET = 27;
    static private final Byte X_CORD_OFFSET = 28;

    ByteArrayOutputStream data;

    public byte[] convertToUDPBeacon(AndroidBeaconDTO androidBeacon) throws IOException {
        data = new ByteArrayOutputStream();

        data.write(androidBeacon.getWhoAmI().byteValue());

        data.write(TYPE_OF_PACKET);
        data.write(PACKET_SIZE);

        insertMacString(androidBeacon.getMyId());
        insertMacString(androidBeacon.getFoundId());

        insertInt_32(androidBeacon.getRssi());
        insertInt_32(androidBeacon.getTxPower());

        data.write(0);
        data.write(ByteBuffer.allocate(20).putInt(0).array());
        data.write(ByteBuffer.allocate(252).putInt(androidBeacon.getRssi()).array());

        System.out.println(data.size());
        System.out.println(data.toByteArray());
        return data.toByteArray();

    }

    public V3 convertPacketToJson(byte[] bytes){
        if (bytes[IS_THERE_CORD_OFFSET] == 0)
            return null;

        int offset = X_CORD_OFFSET;
        int x = convertInt_32ToInteger(bytes,offset);
        offset += 4;
        int y = convertInt_32ToInteger(bytes, offset);
        offset += 4;
        int z = convertInt_32ToInteger(bytes,offset);

        return new V3(x,y,z);
    }

    private void insertMacString(String mac){
        String[] macNums = mac.split(":");

        for (String num: macNums)
            data.write(Integer.parseInt(num.toLowerCase(),16));

        data.write(0);
        data.write(0);
    }


    private void insertInt_32(Integer num){
        byte[] bytes = ByteBuffer.allocate(4).putInt(num).array();
        for (int i = bytes.length - 1; i>=0; i--){
            data.write(bytes[i]);
        }
    }

    private Integer convertInt_32ToInteger(byte[] bytes, int offset){
        byte[] tempBytes = new byte[4];

        for (int i = tempBytes.length - 1; i >= 0; i--){
            tempBytes[i] = bytes[offset++];
        }
        return ByteBuffer.wrap(tempBytes).getInt();
    }


}