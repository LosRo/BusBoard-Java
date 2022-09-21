package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;
import sun.awt.SunToolkit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.ConnectException;

public class Main {
    public static void main(String[] args) {

        // https://api.tfl.gov.uk/StopPoint/?lat=51.503867137208246&lon=-0.11561069427497775&stopTypes=NaptanPublicBusCoachTram
        try {
            Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            WebTarget busRequest = client.target("http://api.postcodes.io/postcodes?lon=-0.11561069427497775&lat=51.503867137208246");
            String response = busRequest.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            System.out.println(response);
            client.close();


            Client client2 = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            WebTarget postCodeRequest = client.target("http://api.postcodes.io/postcodes?lon=-0.11561069427497775&lat=51.503867137208246");
            String response2 = postCodeRequest.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
            System.out.println(response2);
            client2.close();


        }
        catch(Exception ex) {
            System.out.println("Timeout error or unreachable network error.");
            ex.printStackTrace();
        }
    }
}	
