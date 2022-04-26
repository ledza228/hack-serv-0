package by.ledza.hackbsuirserv.socket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AndroidBeaconDTO {

    @JsonProperty("my_id")
    private String myId;

    @JsonProperty("found_id")
    private String foundId;

    @JsonProperty("tx_power")
    private Integer txPower;

    @JsonProperty("rssi")
    private Integer rssi;

    @JsonProperty("who_am_i")
    private Integer whoAmI;
}
