package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;



@JsonIgnoreProperties(ignoreUnknown = true)
public class BusResponses {
    public static String stationName;
    public static String destinationName;
    public static Date expectedArrival;
    


    public BusResponses() {
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public void setExpectedArrival(Date expectedArrival) {
        this.expectedArrival = expectedArrival;
    }
    public void getExpectedArrival(Date expectedArrival) {
        this.expectedArrival = expectedArrival;
    }
}
