package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // https://api.tfl.gov.uk/StopPoint/?lat=51.503867137208246&lon=-0.11561069427497775&stopTypes=NaptanPublicBusCoachTram
        try {
            Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            Scanner scanner = new Scanner(System.in);
            System.out.println("=======================================================================");
            System.out.println("Enter the stop code for your bus");
            String userInput = scanner.nextLine();
            String url = ("https://api.tfl.gov.uk/StopPoint/"+userInput+"/Arrivals");

            WebTarget busRequest = client.target(url);
            // take stop code as input pass param to url 
            busRequest.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType< List<BusResponses> >() {});
            System.out.println("=======================================================================");
            System.out.println("The name of the station is " + BusResponses.stationName);
            System.out.println("The destination of this bus is " + BusResponses.destinationName);
            System.out.println("The expected arrival time is " + BusResponses.expectedArrival);
            System.out.println("=======================================================================");
            
        }
        catch(Exception ex) {      
            System.out.println("Timeout error or unreachable network error.");
            ex.printStackTrace();
        }
    }
}	
