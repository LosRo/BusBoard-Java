package training.busboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import sun.awt.SunToolkit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.net.ConnectException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // https://api.tfl.gov.uk/StopPoint/?lat=51.503867137208246&lon=-0.11561069427497775&stopTypes=NaptanPublicBusCoachTram
        try {
            Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            WebTarget busRequest = client.target("https://api.tfl.gov.uk/StopPoint/490008660N/Arrivals");
            List<busResponses> response = busRequest.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType< List<busResponses> >() {});
            System.out.println(response);
        }
        catch(Exception ex) {
            System.out.println("Timeout error or unreachable network error.");
            ex.printStackTrace();
        }
    }
}	
