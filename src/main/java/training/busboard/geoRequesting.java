package training.busboard;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class geoRequesting {
    public String features;
    public geometry geometry;
    public coordinates coordinates;

    public geoRequesting(){
    }

    public geometry getGeometry(){
        return geometry;
    }

    public coordinates getCoordinates(){
        return coordinates;
    }
}
