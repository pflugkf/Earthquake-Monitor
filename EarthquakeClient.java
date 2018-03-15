
/**
 * Client class for the Earthquake monitor program
 * 
 * @author Kristin Pflug 
 * @version 10/21/14
 */
public class EarthquakeClient
{
    public static void main(String[] args)
    {
        System.out.println("Please enter a location for the earthquake records.");
        String location = UserInput.readString();
        
        SeismicRecords record1 = new SeismicRecords(location);
        
        record1.menu();
    }
}
