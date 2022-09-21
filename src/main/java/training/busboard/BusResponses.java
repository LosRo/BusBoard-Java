package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;



@JsonIgnoreProperties(ignoreUnknown = true)
public class BusResponses {
    public  String stationName;
    public  String destinationName;
    public  Date expectedArrival;
    public  int timeToStation;
    public  String lineId;
    


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
    public Date getExpectedArrival() {
        return expectedArrival;
    }

    public int getTimeToStation() {
        return timeToStation;
    }
    public void setTimeToStation(int timeToStation) {
        this.timeToStation = timeToStation;
    }
    public String getLineId() {
        return lineId;
    }
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
    
}
