package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class busResponses {
    private String stationName;
    private Date expectedArrival;
    private String destinationName;


    public busResponses(String stationName, Date expectedArrival, String destinationName) {
        this.stationName = stationName;
        this.expectedArrival = expectedArrival;
        this.destinationName = destinationName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Date getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(Date expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
}
