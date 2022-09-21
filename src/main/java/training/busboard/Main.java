package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // https://api.tfl.gov.uk/StopPoint/?lat=51.503867137208246&lon=-0.11561069427497775&stopTypes=NaptanPublicBusCoachTram
        try {
            Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            Scanner scanner = new Scanner(System.in);
            System.out.println("===============================================================================");
            System.out.println("Enter the stop code for your bus");
            String userInput = scanner.nextLine();
            String url = ("https://api.tfl.gov.uk/StopPoint/"+userInput+"/Arrivals");

            WebTarget busRequest = client.target(url);
            // take stop code as input pass param to url 
            List<BusResponses> busResponseList = busRequest.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType< List<BusResponses> >() {});
            busResponseList.stream()
            .sorted(Comparator.comparingInt(BusResponses::getTimeToStation))
            .limit(5)
            .forEach(bus -> System.out.println("===============================================================================\n" + "The number of this bus is " + bus.getLineId() + "\nThe bus will be arriving in " + bus.getTimeToStation() + "s" + "\nThe expected arrival for this bus is " + bus.getExpectedArrival() + "\nThe name of this bus station is " + bus.getStationName() + "\n==============================================================================="));
       
            
        }
        catch(Exception ex) {      
            System.out.println("Timeout error or unreachable network error.");
            ex.printStackTrace();
        }
    }
}	
