package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Scanner;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import io.github.cdimascio.dotenv.*;





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

            Dotenv dotenv = null;
            dotenv = Dotenv.configure().load();
            System.getenv(".env");
            String key = dotenv.get("API_KEY");
            

            Client client2 = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter your address/location here");
            String userInput2 = scanner.nextLine();
            String userInputEncoded = URLEncoder.encode(userInput2, StandardCharsets.UTF_8.toString());

            String url2 = ("https://api.geoapify.com/v1/geocode/search?text="+userInputEncoded+"&apiKey="+key+"");
            WebTarget geoRequesting = client.target(url2);
            List<geoRequesting> listOfRequests = geoRequesting.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType <List<geoRequesting>> () {} );
            System.out.println(listOfRequests);

       
            

        }
        catch(Exception ex) {      
            System.out.println("Timeout error or unreachable network error.");
            ex.printStackTrace();
        }
    }
}	
